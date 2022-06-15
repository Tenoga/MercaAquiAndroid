package com.ejemplito.mercaaqui.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.ejemplito.mercaaqui.R
import com.ejemplito.mercaaqui.adapter.ProductAdapter
import com.ejemplito.mercaaqui.adapter.ItemListener
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class ProductsFragment : Fragment(), ItemListener {
    private lateinit var recycler: RecyclerView
    private lateinit var viewAlpha:View
    private lateinit var pgbar: ProgressBar
    private lateinit var rlProductsList: RelativeLayout
    private lateinit var productsList: ArrayList<JSONObject>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("ProductsFragment", "Entered to onCreateView")
        // Inflate the layout for this fragment
        val ll = inflater.inflate(R.layout.fragment_products, container, false)
        val url = "http://192.168.219.17/MercaAqui/app/Http/ListaProductosAll.php"
        val queue = Volley.newRequestQueue(this.context)

        val stringRequest = StringRequest(Request.Method.GET, url, { response ->
            val jsonArray = JSONArray(response)
            this.productsList = ArrayList()
            try {
                var i = 0
                val l = jsonArray.length()
                while (i < l) {
                    productsList.add(jsonArray[i] as JSONObject)
                    i++
                }
                Log.d("ProductFragment", this.productsList.toString())
                this.recycler.adapter = ProductAdapter(this.productsList, this)
                this.viewAlpha.visibility = View.INVISIBLE
                this.pgbar.visibility = View.INVISIBLE

            } catch (e: JSONException) {
            }
        }, { error ->
            Log.w("jsonError", error)
        })
        queue.add(stringRequest)
        this.recycler = ll.findViewById(R.id.products_recycler)
        this.viewAlpha = ll.findViewById(R.id.view_productsList)
        this.pgbar = ll.findViewById(R.id.pgbar_productsList)
        this.rlProductsList = ll.findViewById(R.id.rl_ProductsList)

        return ll
    }

    override fun onItemClicked(product: JSONObject, position: Int) {
        val bundle = bundleOf("product" to product.toString())
        findNavController().navigate(
            R.id.fragment_product_details,
            bundle
        )
    }

}