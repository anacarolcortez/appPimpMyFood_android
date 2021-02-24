package com.dio.pimpmyfood

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReceitaAdapter (var listener: ClickReceita) : RecyclerView.Adapter<ReceitaAdapter.ReceitaAdapterViewHolder>() {
    //classe adapter vai fazer o gerenciamento da lista toda

    private val list: MutableList<Receita> = mutableListOf()

    class ReceitaAdapterViewHolder (itemView: View, var list: List<Receita>, var listener: ClickReceita) : RecyclerView.ViewHolder(itemView){
        //inner class responsável por gerenciar os elementos da lista
        private val tituloCard: TextView = itemView.findViewById(R.id.tituloCard)
        private val fotoCard: ImageView = itemView.findViewById(R.id.imgCard) as ImageView

        init {
            itemView.setOnClickListener {
                listener.clickCardReceita(list[adapterPosition])
            }
        }

        fun bind(receita: Receita){
            tituloCard.text = receita.titulo
            fotoCard.setImageResource(receita.foto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceitaAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_receita, parent, false)
        return ReceitaAdapterViewHolder(view, list, listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ReceitaAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun updateList(list: List<Receita>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}