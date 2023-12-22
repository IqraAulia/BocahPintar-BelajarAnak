package com.example.bocahpintar_belajaranak.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bocahpintar_belajaranak.R
import com.example.bocahpintar_belajaranak.model.data.Buah


class ListAdapter(private val dataset : List<Buah>, private val listener: (Buah)-> Unit): RecyclerView.Adapter<ListAdapter.ItemCardViewHolder>() {
    class ItemCardViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tv_item_name)
        val image: ImageView = view.findViewById(R.id.img_card_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ItemCardViewHolder(view)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: ItemCardViewHolder, position: Int) {
       val content = dataset[position]
        holder.title.text = content.nama
        holder.image.setImageResource(content.image)
        holder.itemView.setOnClickListener{listener(content)}
    }
}