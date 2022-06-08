package com.ejemplito.mercaaqui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.ejemplito.mercaaqui.adapter.ItemListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.json.JSONObject

class MainActivity : AppCompatActivity(), ItemListener {

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

    override fun onItemClicked(product: JSONObject, position: Int) {
        TODO("Not yet implemented")
    }
}