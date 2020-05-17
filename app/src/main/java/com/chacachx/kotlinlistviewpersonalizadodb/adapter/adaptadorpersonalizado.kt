package com.chacachx.kotlinlistviewpersonalizadodb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chacachx.kotlinlistviewpersonalizadodb.R
import com.chacachx.kotlinlistviewpersonalizadodb.dto.Usuario
import com.chacachx.kotlinlistviewpersonalizadodb.interface_click.clickListener
import kotlinx.android.synthetic.main.item_lista.view.*

class adaptadorpersonalizado(
    listaUsuarios: ArrayList<Usuario>,
    var listener: clickListener
) : RecyclerView.Adapter<adaptadorpersonalizado.ViewHolder>() {
    private var listaUsuarios: ArrayList<Usuario>? = null

    init {
        this.listaUsuarios = listaUsuarios
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false),
            listener
        )
    }

    override fun getItemCount(): Int {
        return listaUsuarios?.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombre.text = listaUsuarios?.get(position)?.nombre
        holder.usuario.text = listaUsuarios?.get(position)?.usuario
        Glide.with(holder.itemView).load(listaUsuarios?.get(position)?.imagen).into(holder.imagen)
    }

    class ViewHolder(view: View, listener: clickListener) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        var nombre: TextView = view.nombre
        var usuario: TextView = view.usuario
        var imagen: ImageView = view.imagen
        var listener: clickListener = listener

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            this.listener.onClick(v!!, adapterPosition)
        }
    }
}