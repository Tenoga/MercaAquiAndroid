package com.ejemplito.mercaaqui.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageView
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.ejemplito.mercaaqui.R
import org.json.JSONObject


class VentaDetalleFragment : DialogFragment() {

    private lateinit var tbVentaDets: Toolbar
    private lateinit var idFactura: TextView
    private lateinit var fechaVenta: TextView
    private lateinit var nombreUsuario: TextView
    private lateinit var nombreVendedor: TextView
    private lateinit var idVendedor: TextView
    private lateinit var telefonoVendedor: TextView
    private lateinit var imagenProducto: ImageView
    private lateinit var nombreProducto: TextView
    private lateinit var tipoProducto: TextView
    private lateinit var cantidadProducto: TextView
    private lateinit var precioProducto: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val ll = inflater.inflate(R.layout.fragment_venta_detalle, container, false)

        this.idFactura = ll.findViewById(R.id.idFactura)
        this.fechaVenta = ll.findViewById(R.id.fechaVenta)
        this.nombreUsuario = ll.findViewById(R.id.nombreUsuario)
        this.nombreVendedor = ll.findViewById(R.id.nombreVendedor)
        this.idVendedor = ll.findViewById(R.id.idVendedor)
        this.telefonoVendedor = ll.findViewById(R.id.telefonoVendedor)
        this.imagenProducto = ll.findViewById(R.id.imagenProducto)
        this.nombreProducto = ll.findViewById(R.id.nombreProducto)
        this.tipoProducto = ll.findViewById(R.id.tipoProducto)
        this.cantidadProducto = ll.findViewById(R.id.cantidadProducto)
        this.precioProducto = ll.findViewById(R.id.precioProducto)

        return ll

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.tbVentaDets.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.close)
        this.tbVentaDets.setNavigationOnClickListener{
            dismiss()
    }

    val product = JSONObject(arguments?.getString("product"))

        this.tbVentaDets.title = product.getString("nombre")
        this.id_productoDetails.text = product.getString("id")
        this.nombreProductoDetail.text = product.getString("nombre")
        this.tipoProductoDetail.text = product.getString("tipo")
        this.precioProductDetails.text = product.getString("precio")
        this.cantidadDisponibleDetails.text = product.getString("cantidad_disponible")

        Glide.with(this)
            .load(product.getString("imagen"))
            .into(this.imagenProductDetail)
    }


    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
}


}