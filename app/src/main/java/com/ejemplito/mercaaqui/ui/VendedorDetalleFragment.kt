package com.ejemplito.mercaaqui.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.ejemplito.mercaaqui.R
import org.json.JSONObject

class VendedorDetalleFragment : DialogFragment() {
    private lateinit var tbVendedorDets : Toolbar
    private lateinit var nombreVendedorDetail : TextView
    private lateinit var apellidoVendedorDetail : TextView
    private lateinit var id_vendedorDetail : TextView
    private lateinit var correoVendedorDetail : TextView
    private lateinit var celularVendedorDetail : TextView
    private lateinit var nacimientoVendedorDetail : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val ll = inflater.inflate(R.layout.fragment_vendedor_detalle, container, false)
        this.tbVendedorDets = ll.findViewById(R.id.tbVendedorDets)

        this.nombreVendedorDetail = ll.findViewById(R.id.nombreVendedorDetail)
        this.apellidoVendedorDetail = ll.findViewById(R.id.apellidoVendedorDetail)
        this.id_vendedorDetail = ll.findViewById(R.id.id_vendedorDetail)
        this.correoVendedorDetail = ll.findViewById(R.id.correoVendedorDetail)
        this.celularVendedorDetail = ll.findViewById(R.id.celularVendedorDetail)
        this.nacimientoVendedorDetail = ll.findViewById(R.id.nacimientoVendedorDetail)

        return ll
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.tbVendedorDets.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.close)
        this.tbVendedorDets.setNavigationOnClickListener{
            dismiss()
        }

        val vendedor = JSONObject(arguments?.getString("vendedor"))

        this.tbVendedorDets.title = vendedor.getString("nombre")
        this.nombreVendedorDetail.text = vendedor.getString("nombre")
        this.apellidoVendedorDetail.text = vendedor.getString("apellido")
        this.id_vendedorDetail.text = vendedor.getString("id")
        this.correoVendedorDetail.text = vendedor.getString("email")
        this.celularVendedorDetail.text = vendedor.getString("celular")
        this.nacimientoVendedorDetail.text = vendedor.getString("fecha_nacimiento")

    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }
}