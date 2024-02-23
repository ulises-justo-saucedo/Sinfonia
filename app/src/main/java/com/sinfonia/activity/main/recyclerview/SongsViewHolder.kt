package com.sinfonia.activity.main.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sinfonia.R
import java.io.File

class SongsViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val tvSongName = view.findViewById<TextView>(R.id.tvSongName)
    fun render(song: File){
        tvSongName.text = song.nameWithoutExtension
    }
}