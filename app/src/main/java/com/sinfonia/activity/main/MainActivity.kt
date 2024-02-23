package com.sinfonia.activity.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sinfonia.R
import com.sinfonia.activity.addsongs.AddSongsActivity
import com.sinfonia.activity.hideSystemUI

class MainActivity : AppCompatActivity() {
    private lateinit var cvNoSongs: CardView
    private lateinit var btnAdd: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemUI(this)
        setContentView(R.layout.activity_main)
        initComponents()
        initListeners()
    }
    private fun initComponents(){
        cvNoSongs = findViewById(R.id.cvNoSongs)
        btnAdd = findViewById(R.id.btn_add)
    }
    private fun initListeners(){
        btnAdd.setOnClickListener {
            startActivity(Intent(this,AddSongsActivity::class.java))
        }
    }
}