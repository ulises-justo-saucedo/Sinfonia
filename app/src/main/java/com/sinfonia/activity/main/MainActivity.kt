package com.sinfonia.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.sinfonia.R
import com.sinfonia.activity.hideSystemUI
import com.sinfonia.files.AppFilesManager

class MainActivity : AppCompatActivity() {
    private lateinit var cvNoSongs: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemUI(this)
        setContentView(R.layout.activity_main)
        initComponents()
        noSongsMessage()
    }
    private fun initComponents(){
        cvNoSongs = findViewById(R.id.cvNoSongs)
    }
    private fun noSongsMessage(){
        when(AppFilesManager.userHasSongs()){
            true -> cvNoSongs.visibility = CardView.GONE
            false -> cvNoSongs.visibility = CardView.VISIBLE
        }
    }
}