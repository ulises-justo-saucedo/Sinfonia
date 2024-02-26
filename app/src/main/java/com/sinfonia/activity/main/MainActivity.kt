package com.sinfonia.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sinfonia.R
import com.sinfonia.activity.hideSystemUI
import com.sinfonia.activity.main.recyclerview.SongsAdapter
import com.sinfonia.files.AppSongsManager

class MainActivity : AppCompatActivity() {
    private lateinit var appSongsManager: AppSongsManager
    private lateinit var cvNoSongs: CardView
    private lateinit var rvSongs: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemUI(this)
        setContentView(R.layout.activity_main)
        initComponents()
        loadUserSongs()
        configView()
        initRecyclerView()
    }
    private fun initComponents(){
        appSongsManager = AppSongsManager(this)
        cvNoSongs = findViewById(R.id.cvNoSongs)
        rvSongs = findViewById(R.id.rvSongs)
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
}