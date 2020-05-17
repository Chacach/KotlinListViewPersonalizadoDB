package com.chacachx.kotlinlistviewpersonalizadodb.querys

import android.content.Context
import android.util.Log
import com.chacachx.kotlinlistviewpersonalizadodb.database.database
import com.chacachx.kotlinlistviewpersonalizadodb.dto.Usuario

class query {
    fun consulta_usuarios(context: Context): ArrayList<Usuario> {
        var listaUsuarios: ArrayList<Usuario> = ArrayList()
        val query = "SELECT * FROM USUARIOS"
        val basededatos = database(context, "DB_USUARIOS", null, 1)
        val basededatoslectura = basededatos.readableDatabase
        var fila = basededatoslectura.rawQuery(query, null)
        while (fila.moveToNext()) {
            listaUsuarios.add(
                Usuario(
                    fila.getString(0),
                    fila.getString(1),
                    fila.getString(2)
                )
            )
        }
        return listaUsuarios
    }
}