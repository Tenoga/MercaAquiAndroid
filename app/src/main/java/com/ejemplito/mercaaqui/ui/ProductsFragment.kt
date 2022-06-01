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
import com.ejemplito.mercaaqui.adapter.ProductAdapter
import com.ejemplito.mercaaqui.adapter.ProductsListener
import com.ejemplito.mercaaqui.models.Product
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class ProductsFragment : Fragment(), ProductsListener {
    private lateinit var recycler: RecyclerView
    private lateinit var viewAlpha:View
    private lateinit var pgbar: ProgressBar
    private lateinit var rlProductsList: RelativeLayout
    private lateinit var productsList: ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("ProductsFragment", "Entered to onCreateView")
        // Inflate the layout for this fragment
        val ll = inflater.inflate(R.layout.fragment_products, container, false)
        /*val url = "http://10.190.80.192/MercaAqui/app/Http/ListaProductosAll.php"
        val queue = Volley.newRequestQueue(this.context)

        val stringRequest = StringRequest(Request.Method.GET, url, { response ->
            val jsonArray = JSONArray(response)
            this.productsList = ArrayList()
            try {
                var i = 0
                val l = jsonArray.length()
                while (i < l) {
                    productsList.add(jsonArray[i] as Product)
                    i++
                }
            } catch (e: JSONException) {
            }
        }, { error ->
            Log.w("jsonError", error)
        })
        queue.add(stringRequest)
        this.recycler = ll.findViewById(R.id.products_recycler)
        this.viewAlpha = ll.findViewById(R.id.view_productsList)
        this.pgbar = ll.findViewById(R.id.pgbar_productsList)
        this.rlProductsList = ll.findViewById(R.id.rl_ProductsList)*/

        return ll
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("ProductFragment", this.productsList.toString())
        /*recycler.adapter = ProductAdapter(this.productsList, this)
        viewAlpha.visibility = View.INVISIBLE
        pgbar.visibility = View.INVISIBLE*/
    }

    override fun onProductClicked(product: JSONObject, position: Int) {
        TODO("Not yet implemented")
    }

}