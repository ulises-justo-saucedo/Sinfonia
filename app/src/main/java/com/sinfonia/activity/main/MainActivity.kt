package com.sinfonia.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.sinfonia.R
import com.sinfonia.activity.hideSystemUI

class MainActivity : AppCompatActivity() {
    private lateinit var cvNoSongs: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemUI(this)
        setContentView(R.layout.activity_main)
        initComponents()
    }
    private fun initComponents(){
        cvNoSongs = findViewById(R.id.cvNoSongs)
    }
}