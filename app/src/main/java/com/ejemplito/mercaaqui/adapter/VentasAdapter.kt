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

class VentasAdapter(private val ventasList: ArrayList<JSONObject>, private val itemListener: ItemListener) : RecyclerView.Adapter<VentasAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var fecha_venta: TextView = view.findViewById(R.id.fechaVenta)
        //var vendedor_id: TextView = view.findViewById(R.id.vendedor_id)
        //var nombre_vendedor: TextView = view.findViewById(R.id.nombre_vendedor)
        var nombre_cliente: TextView = view.findViewById(R.id.nombreUsuario)
        var total: TextView = view.findViewById(R.id.ventaTotal)

        fun bind(product: JSONObject) {
            fecha_venta.text = product.getString("fecha_venta")
            //vendedor_id.text = product.getString("fecha_venta")
            nombre_cliente.text = product.getString("nombre_cliente")
            total.text = product.getString("total")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(
        LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_ventas, parent, false)
    )

    override fun getItemCount() = this.ventasList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = ventasList[position]
        try {
            holder.bind(product)

            holder.itemView.setOnClickListener{
                itemListener.onItemClicked(product, position)
            }

        }catch (e: Exception){
            Log.w("ProductImagen", "No cargó la imagen")
        }

    }
}