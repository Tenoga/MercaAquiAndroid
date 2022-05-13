package com.ejemplito.mercaaqui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val url = "http://192.168.191.204/#"
        val queue = Volley.newRequestQueue(this)
        val tvNombre = findViewById<TextView>(R.id.tVnombrep)
        val tvDescripcion = findViewById<TextView>(R.id.tvDescripcion)
        val stringRequest = StringRequest(Request.Method.GET, url, Response.Listener { response ->
            val jsonArray = JSONArray(response)
                for (i in 0 until jsonArray.length()){
                    val jsonObject = JSONObject(jsonArray.getString(i))

                    var text = jsonObject.get("nombreP")
                    tvNombre.text = jsonObject.get("nombreP").toString()
                    tvDescripcion.text = jsonObject.get("descripcionP").toString()
                }
        }, Response.ErrorListener { error ->

        })
        queue.add(stringRequest)

    }
}