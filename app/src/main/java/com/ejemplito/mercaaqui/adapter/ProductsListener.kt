package com.ejemplito.mercaaqui.adapter

import com.ejemplito.mercaaqui.models.Product

interface ProductsListener {
    fun onProductClicked(product: Product, position: Int)
}