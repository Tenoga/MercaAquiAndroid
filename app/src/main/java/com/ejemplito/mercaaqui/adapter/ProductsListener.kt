package com.ejemplito.mercaaqui.adapter

import com.ejemplito.mercaaqui.models.Product
import org.json.JSONObject

interface ProductsListener {
    fun onProductClicked(product: JSONObject, position: Int)
}