package com.ejemplito.mercaaqui.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ejemplito.mercaaqui.R
import com.ejemplito.mercaaqui.adapter.ItemListener
import com.ejemplito.mercaaqui.adapter.ProductAdapter
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class VentaDetalleFragment : DialogFragment(),  ItemListener{

    private lateinit var tbVentaDets: Toolbar
    private lateinit var recycler: RecyclerView
    private lateinit var viewAlpha:View
    private lateinit var pgbar: ProgressBar
    private lateinit var rlProductsList: RelativeLayout
    private lateinit var idFactura: TextView
    private lateinit var fechaVenta: TextView
    private lateinit var nombreUsuario: TextView
    private lateinit var idVendedor: TextView
    private lateinit var productsList: ArrayList<JSONObject>



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

        this.tbVentaDets = ll.findViewById(R.id.tbVentaDets)
        this.idFactura = ll.findViewById(R.id.idFactura)
        this.fechaVenta = ll.findViewById(R.id.fechaVenta)
        this.nombreUsuario = ll.findViewById(R.id.nombreUsuario)
        this.idVendedor = ll.findViewById(R.id.idVendedor)
        this.recycler = ll.findViewById(R.id.productsVentas_recycler)
        this.viewAlpha = ll.findViewById(R.id.view_productsVentasList)
        this.pgbar = ll.findViewById(R.id.pgbar_productsVentasList)
        this.rlProductsList = ll.findViewById(R.id.rl_ProductsVentasList)
        return ll

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.tbVentaDets.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.close)
        this.tbVentaDets.setNavigationOnClickListener{
            dismiss()
    }

    val venta = JSONObject(arguments?.getString("venta"))

        this.tbVentaDets.title = venta.getString("nombre_cliente")
        this.idFactura.text = venta.getString("id")
        this.fechaVenta.text = venta.getString("fecha_venta")
        this.nombreUsuario.text = venta.getString("nombre_cliente")
        this.idVendedor.text = venta.getString("vendedor_id")

        val productos = JSONArray(venta.getString("producto"))
        this.productsList = ArrayList()

        var i = 0
        val l = productos.length()
        while (i < l) {
            this.productsList.add(productos[i] as JSONObject)
            i++
        }

        this.recycler.adapter = ProductAdapter(productsList, this)
        this.viewAlpha.visibility = View.INVISIBLE
        this.pgbar.visibility = View.INVISIBLE

    }


    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
}

    override fun onItemClicked(product: JSONObject, position: Int) {
        try {
            //TODO("Not yet implemented")
        } catch (e: NotImplementedError) {
            Log.d("VentaDetalleFragment", "Not yet implemented")
        }
    }


}