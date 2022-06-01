package com.ejemplito.mercaaqui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.INFO
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.ejemplito.mercaaqui.adapter.ProductAdapter
import com.ejemplito.mercaaqui.adapter.ProductsListener
import com.ejemplito.mercaaqui.models.Product
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity(), ProductsListener {
    private lateinit var appBarConfiguration : AppBarConfiguration
    private lateinit var productsList: ArrayList<JSONObject>
    private lateinit var recycler: RecyclerView
    private lateinit var viewAlpha: View
    private lateinit var pgbar: ProgressBar
    private lateinit var rlProductsList: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_products)

        Log.d("MainActivity", "Entered to onCreate")
        this.productsList = ArrayList()
        val queue = Volley.newRequestQueue(this)

        val url = "http://10.190.80.192/MercaAqui/app/Http/ListaProductosAll.php"
        val stringRequest = StringRequest(Request.Method.GET, url, { response ->
            Log.w("jsonArray", response)
            val jsonArray = JSONArray(response)
            try {
                var i = 0
                val l = jsonArray.length()
                while (i < l) {
                    this.productsList.add(jsonArray[i] as JSONObject)
                    i++
                }
                Log.d("MainActivity", this.productsList.toString())
                this.recycler.adapter = ProductAdapter(this.productsList, this)
                this.viewAlpha.visibility = View.INVISIBLE
                this.pgbar.visibility = View.INVISIBLE

            } catch (e: JSONException) {
                Log.w("jsonError", e)
            }
        }, { error ->
            Log.w("jsonError", error)
        })
        queue.add(stringRequest)

        this.recycler = findViewById(R.id.products_recycler)
        this.viewAlpha = findViewById(R.id.view_productsList)
        this.pgbar = findViewById(R.id.pgbar_productsList)
        this.rlProductsList = findViewById(R.id.rl_ProductsList)



        //Toolbar
        /*findViewById<Toolbar>(R.id.toolbar).apply {
            setSupportActionBar(this)
            supportActionBar?.title = null
            supportActionBar?.setDisplayShowTitleEnabled(false)
        }*/

        //Navigation
        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.contenedor) as NavHostFragment? ?: return

        // Set up Action Bar
        val navController = host.navController

        appBarConfiguration = AppBarConfiguration(navController.graph)

        setupActionBar(navController, appBarConfiguration)

        setupBottomNavMenu(navController)

        setupBottomNavMenu(navController)
        /*val bottomNavigationView: BottomNavigationView = findViewById(R.id.bNMain)
        val navController = findNavController(R.id.contenedor)
        val appBarConfig = AppBarConfiguration(
            setOf(
                R.id.nHome,
                R.id.nProducts,
                R.id.nVentas,
                R.id.nVendedores
            )
        )
        setupActionBarWithNavController(navController, appBarConfig)
        bottomNavigationView.setupWithNavController(navController)*/
    }

    private fun setupBottomNavMenu(navController: NavController) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bNMain)
        bottomNav?.setupWithNavController(navController)
    }

    private fun setupActionBar(navController: NavController,
                               appBarConfig : AppBarConfiguration
    ) {
        setupActionBarWithNavController(navController, appBarConfig)
    }

    override fun onProductClicked(product: JSONObject, position: Int) {
        TODO("Not yet implemented")
    }
}