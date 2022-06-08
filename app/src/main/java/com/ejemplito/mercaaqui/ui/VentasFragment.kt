package com.ejemplito.mercaaqui.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.ejemplito.mercaaqui.R
import com.ejemplito.mercaaqui.adapter.ItemListener
import com.ejemplito.mercaaqui.adapter.ProductAdapter
import com.ejemplito.mercaaqui.adapter.VentasAdapter
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class VentasFragment : Fragment(), ItemListener {
    private lateinit var recycler: RecyclerView
    private lateinit var viewAlpha:View
    private lateinit var pgbar: ProgressBar
    private lateinit var rlVentasList: RelativeLayout
    private lateinit var ventasList: ArrayList<JSONObject>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("VentasFragment", "Entered to onCreateView")
        // Inflate the layout for this fragment
        val ll = inflater.inflate(R.layout.fragment_ventas, container, false)
        val url = "http://10.190.80.196/MercaAqui/app/Http/ListaVentasAll.php"
        val queue = Volley.newRequestQueue(this.context)

        val stringRequest = StringRequest(Request.Method.GET, url, { response ->
            val jsonArray = JSONArray(response)
            this.ventasList = ArrayList()
            try {
                var i = 0
                val l = jsonArray.length()
                while (i < l) {
                    ventasList.add(jsonArray[i] as JSONObject)
                    i++
                }
                Log.d("VentasFragment", this.ventasList.toString())
                this.recycler.adapter = VentasAdapter(this.ventasList, this)
                this.viewAlpha.visibility = View.INVISIBLE
                this.pgbar.visibility = View.INVISIBLE

            } catch (e: JSONException) {
            }
        }, { error ->
            Log.w("jsonError", error)
        })
        queue.add(stringRequest)
        this.recycler = ll.findViewById(R.id.ventas_recycler)
        this.viewAlpha = ll.findViewById(R.id.view_ventasList)
        this.pgbar = ll.findViewById(R.id.pgbar_ventasList)
        this.rlVentasList = ll.findViewById(R.id.rl_VentasList)

        return ll
    }

    override fun onItemClicked(product: JSONObject, position: Int) {
        TODO("Not yet implemented")
    }


}