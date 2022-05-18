package com.ejemplito.mercaaqui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import org.json.JSONArray
import org.json.JSONObject

class Products : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val ll = inflater.inflate(R.layout.fragment_products, container, false)
        val url = "http://10.190.80.192/MercaAqui/app/Http/ListaProductosAll.php"
       val queue = Volley.newRequestQueue(this.context)
       val pId = ll.findViewById<TextView>(R.id.pId)
       val iVimagen = ll.findViewById<ImageView>(R.id.iVimagen)
       val tVnombre = ll.findViewById<TextView>(R.id.tVnombre)
       val tVtipo = ll.findViewById<TextView>(R.id.tVtipo)
       val tVprecio = ll.findViewById<TextView>(R.id.tVprecio)
       val tVcantidadDisponible = ll.findViewById<TextView>(R.id.tVcantidad_disponible)

       val stringRequest = StringRequest(Request.Method.GET, url, { response ->
           val jsonArray = JSONArray(response)
           for (i in 0 until jsonArray.length()) {
               val jsonObject = JSONObject(jsonArray.getString(i))

               pId.text = jsonObject.get("id").toString()
               tVnombre.text = jsonObject.get("nombre").toString()
               tVtipo.text = jsonObject.get("tipo").toString()
               tVprecio.text = jsonObject.get("precio").toString()
               tVcantidadDisponible.text = jsonObject.get("cantidad_disponible").toString()


               Glide.with(this).load(jsonObject.get("imagen").toString()).into(iVimagen)
           }
       }, { error ->

       })
       queue.add(stringRequest)
        return ll;
    }


}