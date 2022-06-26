package com.farhanms.responsi.ModulRead

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.farhanms.responsi.Data
import com.farhanms.responsi.R

class Adapter (
    private var data: List<Data>,
    private val listener: (Data) -> Unit
)
: RecyclerView.Adapter<Adapter.LeagueViewHolder>() {

    lateinit var ContextAdapter : Context

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        ContextAdapter = parent.context
        val inflatedView: View = layoutInflater.inflate(R.layout.row_data, parent, false)

        return LeagueViewHolder(inflatedView)
    }


    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(data[position], listener, ContextAdapter, position)

    }

    override fun getItemCount(): Int = data.size

    class LeagueViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val nama: TextView = view.findViewById(R.id.nama)
        private val nim: TextView = view.findViewById(R.id.nim)


        fun bindItem(data: Data, listener: (Data) -> Unit, context: Context, position: Int) {

            nama.text = data.nama
            nim.text = data.nim

            itemView.setOnClickListener {
                listener(data)
            }
        }

    }



}

