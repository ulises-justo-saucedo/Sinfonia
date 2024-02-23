package com.sinfonia.activity.main.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sinfonia.R
import java.io.File

class SongsAdapter(private val songs: MutableList<File>): RecyclerView.Adapter<SongsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsViewHolder {
        return SongsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.song_element,parent,false))
    }
    override fun getItemCount(): Int = songs.size
    override fun onBindViewHolder(holder: SongsViewHolder, position: Int) {
        holder.render(songs[position])
    }
}