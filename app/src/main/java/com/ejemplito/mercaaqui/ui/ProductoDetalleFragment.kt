package com.ejemplito.mercaaqui.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ejemplito.mercaaqui.R
import org.json.JSONObject

class ProductoDetalleFragment : DialogFragment() {
    private lateinit var tbProductDets : Toolbar
    private lateinit var id_productoDetails : TextView
    private lateinit var nombreProductoDetail : TextView
    private lateinit var tipoProductoDetail : TextView
    private lateinit var cantidadDisponibleDetails : TextView
    private lateinit var precioProductDetails : TextView
    private lateinit var imagenProductDetail : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val ll = inflater.inflate(R.layout.fragment_producto_detalle, container, false)
        this.tbProductDets = ll.findViewById(R.id.tbProductDets)


        this.id_productoDetails = ll.findViewById(R.id.id_productoDetails)
        this.nombreProductoDetail = ll.findViewById(R.id.nombreProductoDetail)
        this.tipoProductoDetail = ll.findViewById(R.id.tipoProductoDetail)
        this.precioProductDetails = ll.findViewById(R.id.precioProductoDetail)
        this.imagenProductDetail = ll.findViewById(R.id.imagenProductoDetail)
        this.cantidadDisponibleDetails = ll.findViewById(R.id.cantidadDisponibleDetails)
        return ll
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.tbProductDets.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.close)
        this.tbProductDets.setNavigationOnClickListener{
            dismiss()
        }

        val product = JSONObject(arguments?.getString("product"))

        this.tbProductDets.title = product.getString("nombre")
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