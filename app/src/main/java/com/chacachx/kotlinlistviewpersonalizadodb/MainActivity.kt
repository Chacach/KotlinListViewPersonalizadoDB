package com.chacachx.kotlinlistviewpersonalizadodb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chacachx.kotlinlistviewpersonalizadodb.adapter.adaptadorpersonalizado
import com.chacachx.kotlinlistviewpersonalizadodb.interface_click.clickListener
import com.chacachx.kotlinlistviewpersonalizadodb.querys.query

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listaPersonalizada = findViewById<RecyclerView>(R.id.listaPersonalizada)

        var listaUsuarios = query().consulta_usuarios(applicationContext)
        val layoutManager: RecyclerView.LayoutManager
        layoutManager = LinearLayoutManager(applicationContext)

        val adaptador: adaptadorpersonalizado
        adaptador =
            adaptadorpersonalizado(listaUsuarios,  object:
                clickListener {
                override fun onClick(view: View, position: Int) {
                    Toast.makeText(applicationContext, listaUsuarios.get(position).nombre, Toast.LENGTH_LONG).show()
                }

            })
        listaPersonalizada.layoutManager = layoutManager
        listaPersonalizada.adapter = adaptador
    }
}
