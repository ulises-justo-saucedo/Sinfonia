package com.sinfonia.activity.main.recyclerview

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sinfonia.R
import com.sinfonia.activity.main.recyclerview.song.Song

class SongsViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val tvSongName = view.findViewById<TextView>(R.id.tvSongName)
    val btnPlay = view.findViewById<Button>(R.id.btnPlay)
    fun render(song: Song,songs: MutableList<Song>){
        tvSongName.text = song.file.nameWithoutExtension
        btnPlay.setOnClickListener {
            for(s in songs){
                if(s.mediaPlayer.isPlaying){
                    s.mediaPlayer.stop()
                    s.mediaPlayer.prepare()
                }
            }
            song.mediaPlayer.start()
        }
    }
}