package com.ejemplito.mercaaqui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ejemplito.mercaaqui.R
import org.json.JSONObject

class VendedorAdapter (private val vendedoresList: ArrayList<JSONObject>, private val itemListener: ItemListener) : RecyclerView.Adapter<VendedorAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var nombre: TextView = view.findViewById(R.id.nombreVendedor)
        var apellido: TextView = view.findViewById(R.id.apellidoVendedor)
        var email: TextView = view.findViewById(R.id.emailVendedor)
        //var celular: TextView = view.findViewById(R.id.precioProducto)
        //var fecha_nacimiento: TextView = view.findViewById(R.id.precioProducto)

        fun bind(product: JSONObject) {
            nombre.text = product.getString("nombre")
            apellido.text = product.getString("apellido")
            email.text = product.getString("email")
            //celular.text = product.getString("precio")
            //fecha_nacimiento.text = product.getString("precio")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(
        LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_vendedor, parent, false)
    )

    override fun getItemCount() = this.vendedoresList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = vendedoresList[position]
        holder.bind(product)
        holder.itemView.setOnClickListener{
            itemListener.onItemClicked(product, position)
        }


    }
}