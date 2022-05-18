package com.ejemplito.mercaaqui.models

import java.io.Serializable

class Product : Serializable {
    var nombre: String = String()
    var tipo: String = String()
    var precio: Int = 0
    var cantidad_disponible: Int = 0
    var imagen: String = String()
}
