package com.sinfonia.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sinfonia.R
import com.sinfonia.activity.hideSystemUI
import com.sinfonia.activity.main.recyclerview.SongsAdapter
import com.sinfonia.activity.main.recyclerview.song.Song
import com.sinfonia.files.AppSongsManager

class MainActivity : AppCompatActivity() {
    private lateinit var appSongsManager: AppSongsManager
    private lateinit var cvNoSongs: CardView
    private lateinit var rvSongs: RecyclerView
    private lateinit var btnPlayRandomSongs: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemUI(this)
        setContentView(R.layout.activity_main)
        initComponents()
        loadUserSongs()
        configView()
        initRecyclerView()
        initListeners()
    }
    private fun initComponents(){
        appSongsManager = AppSongsManager(this)
        cvNoSongs = findViewById(R.id.cvNoSongs)
        rvSongs = findViewById(R.id.rvSongs)
        btnPlayRandomSongs = findViewById(R.id.btnPlayRandomSongs)
    }
    private fun loadUserSongs(){
        appSongsManager.refreshSongs()
    }
    private fun configView(){
        when(appSongsManager.userHasSongs()){
            true -> hideNoSongsMessage()
            false -> showNoSongsMessage()
        }
    }
    private fun hideNoSongsMessage(){
        cvNoSongs.visibility = CardView.GONE
        rvSongs.visibility = RecyclerView.VISIBLE
    }
    private fun showNoSongsMessage(){
        cvNoSongs.visibility = CardView.VISIBLE
        rvSongs.visibility = RecyclerView.GONE
    }
    private fun initRecyclerView(){
        rvSongs.layoutManager = LinearLayoutManager(this)
        rvSongs.adapter = SongsAdapter(appSongsManager.songs)
    }
    private fun initListeners(){
        btnPlayRandomSongs.setOnClickListener {
            appSongsManager.stopRandomizedSongs()
            appSongsManager.randomizeSongs()
            appSongsManager.playRandomizedSongs()
        }
    }
}