package com.ejemplito.mercaaqui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ejemplito.mercaaqui.R
import com.ejemplito.mercaaqui.models.Product

class ProductAdapter(private val productsList: ArrayList<Any>, private val productsListener: ProductsListener) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var nombre: TextView = view.findViewById(R.id.nombreProducto)
        var tipo: TextView = view.findViewById(R.id.tipoProducto)
        var precio: TextView = view.findViewById(R.id.precioProducto)
        var imagen: ImageView = view.findViewById(R.id.imagenProducto)

        fun bind(product: Product) {
            nombre.text = product.nombre
            tipo.text = product.tipo
            precio.text = product.precio.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(
        LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_product, parent, false)
    )

    override fun getItemCount() = this.productsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                val product = productsList[position]
        try {
            Glide.with(holder.itemView.context)
                .load(product.imagen)
                .into(holder.imagen)
            holder.bind(product)

            holder.itemView.setOnClickListener{
                productsListener.onProductClicked(product, position)
            }

        }catch (e: Exception){
            Log.w("ProductImagen", "No cargó la imagen")
        }

    }
}