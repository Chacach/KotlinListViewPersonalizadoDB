package com.chacachx.kotlinlistviewpersonalizadodb.dto

class Usuario(usuario: String, nombre: String, imagen: String) {
    var usuario: String = ""
    var nombre: String = ""
    var imagen: String = ""

    init {
        this.usuario = usuario
        this.nombre = nombre
        this.imagen = imagen
    }
}