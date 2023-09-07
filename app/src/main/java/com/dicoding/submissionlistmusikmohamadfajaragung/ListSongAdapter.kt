package com.dicoding.submissionlistmusikmohamadfajaragung

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text


class ListSongAdapter (private val context: Context, private val listSong: ArrayList<Song>) :RecyclerView.Adapter<ListSongAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_song, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listSong.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
       val (name, genre, photo) = listSong[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvGenre.text = genre

        val itemList = listSong[position]

       holder.itemView.setOnClickListener{
           val intent = Intent(context, MainActivity2::class.java )
           intent.putExtra("lyrics",itemList.lyrics)
           intent.putExtra("photo",itemList.photo)
           intent.putExtra("judul",itemList.name)
           intent.putExtra("genre",itemList.genre)
           context.startActivity(intent)
       }

    }


    class ListViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val imgPhoto : ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName :TextView = itemView.findViewById(R.id.tv_item_name)
        val tvGenre: TextView = itemView.findViewById(R.id.tv_item_genre)


    }

}