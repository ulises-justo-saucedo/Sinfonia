package com.sinfonia.activity.main.recyclerview

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sinfonia.R
import com.sinfonia.activity.main.recyclerview.song.Song

class SongsViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val tvSongName = view.findViewById<TextView>(R.id.tvSongName)
    val btnPlay = view.findViewById<FloatingActionButton>(R.id.btnPlay)
    val btnStop = view.findViewById<FloatingActionButton>(R.id.btnStop)
    fun render(song: Song,songs: MutableList<Song>){
        tvSongName.text = song.file.nameWithoutExtension
        btnPlay.setOnClickListener {
            for(s in songs){
                s.mediaPlayer.stop()
                s.mediaPlayer.prepare()
            }
            song.mediaPlayer.start()
            Log.i("TIME_SONG",song.mediaPlayer.timestamp.toString())
        }
        btnStop.setOnClickListener {
            song.mediaPlayer.pause()
        }
    }
}