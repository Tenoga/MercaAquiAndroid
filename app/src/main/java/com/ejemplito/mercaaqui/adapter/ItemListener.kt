package com.ejemplito.mercaaqui.adapter

import com.ejemplito.mercaaqui.models.Product
import org.json.JSONObject

interface ItemListener {
    fun onItemClicked(product: JSONObject, position: Int)
}