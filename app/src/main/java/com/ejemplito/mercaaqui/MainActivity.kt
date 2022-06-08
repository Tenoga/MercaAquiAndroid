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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "Entered to onCreate")

        //Toolbar
        findViewById<Toolbar>(R.id.toolbar).apply {
            setSupportActionBar(this)
            supportActionBar?.title = null
            supportActionBar?.setDisplayShowTitleEnabled(false)
        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bNMain)
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
        bottomNavigationView.setupWithNavController(navController)
    }

    override fun onProductClicked(product: JSONObject, position: Int) {
        TODO("Not yet implemented")
    }
}