package com.ejemplito.mercaaqui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val url = "http://192.168.191.204/mercaaqui/app/Http/ListaProductosAll.php"
        val queue = Volley.newRequestQueue(this)
        val pId = findViewById<TextView>(R.id.pId)
        val iVimagen = findViewById<ImageView>(R.id.iVimagen)
        val tVnombre = findViewById<TextView>(R.id.tVnombre)
        val tVtipo = findViewById<TextView>(R.id.tVtipo)
        val tVprecio = findViewById<TextView>(R.id.tVprecio)
        val tVcantidad_disponible = findViewById<TextView>(R.id.tVcantidad_disponible)

        val stringRequest = StringRequest(Request.Method.GET, url, Response.Listener { response ->
            val jsonArray = JSONArray(response)
                for (i in 0 until jsonArray.length()){
                    val jsonObject = JSONObject(jsonArray.getString(i))

                    pId.text = jsonObject.get("id").toString()
                    tVnombre.text = jsonObject.get("nombre").toString()
                    tVtipo.text = jsonObject.get("tipo").toString()
                    tVprecio.text = jsonObject.get("precio").toString()
                    tVcantidad_disponible.text = jsonObject.get("cantidad_disponible").toString()


                    Glide.with(this).load(jsonObject.get("imagen").toString()).into(iVimagen)
                }
        }, Response.ErrorListener { error ->

        })
        queue.add(stringRequest)

    }
}