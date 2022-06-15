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
import com.ejemplito.mercaaqui.adapter.VendedorAdapter
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class VendedoresFragment : Fragment(), ItemListener {
    private lateinit var recycler: RecyclerView
    private lateinit var viewAlpha:View
    private lateinit var pgbar: ProgressBar
    private lateinit var rlVendedoresList: RelativeLayout
    private lateinit var vendedoresList: ArrayList<JSONObject>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("VendedoresFragment", "Entered to onCreateView")
        // Inflate the layout for this fragment
        val ll = inflater.inflate(R.layout.fragment_vendedores, container, false)
        val url = "http://192.168.96.16/MercaAqui/app/Http/ListaVendedoresAll.php"
        val queue = Volley.newRequestQueue(this.context)

        val stringRequest = StringRequest(Request.Method.GET, url, { response ->
            val jsonArray = JSONArray(response)
            this.vendedoresList = ArrayList()
            try {
                var i = 0
                val l = jsonArray.length()
                while (i < l) {
                    vendedoresList.add(jsonArray[i] as JSONObject)
                    i++
                }
                Log.d("VendedoresFragment", this.vendedoresList.toString())
                this.recycler.adapter = VendedorAdapter(this.vendedoresList, this)
                this.viewAlpha.visibility = View.INVISIBLE
                this.pgbar.visibility = View.INVISIBLE

            } catch (e: JSONException) {
            }
        }, { error ->
            Log.w("jsonError", error)
        })
        queue.add(stringRequest)
        this.recycler = ll.findViewById(R.id.vendedores_recycler)
        this.viewAlpha = ll.findViewById(R.id.view_vendedoresList)
        this.pgbar = ll.findViewById(R.id.pgbar_vendedoresList)
        this.rlVendedoresList = ll.findViewById(R.id.rl_vendedoresList)

        return ll
    }

    override fun onItemClicked(product: JSONObject, position: Int) {
        TODO("Not yet implemented")
    }

}