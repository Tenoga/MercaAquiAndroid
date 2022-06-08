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
import org.json.JSONObject

class ProductAdapter(private val productsList: ArrayList<JSONObject>, private val itemListener: ItemListener) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var nombre: TextView = view.findViewById(R.id.nombreProducto)
        var tipo: TextView = view.findViewById(R.id.tipoProducto)
        var precio: TextView = view.findViewById(R.id.precioProducto)
        var imagen: ImageView = view.findViewById(R.id.imagenProducto)

        fun bind(product: JSONObject) {
            nombre.text = product.getString("nombre")
            tipo.text = product.getString("tipo")
            precio.text = product.getString("precio")
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
                .load(product.get("imagen"))
                .into(holder.imagen)
            holder.bind(product)

            holder.itemView.setOnClickListener{
                itemListener.onItemClicked(product, position)
            }

        }catch (e: Exception){
            Log.w("ProductImagen", "No cargó la imagen")
        }

    }
}