package com.sinfonia.activity.launch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.sinfonia.R
import com.sinfonia.activity.hideSystemUI
import com.sinfonia.activity.main.MainActivity

class FirstActivity : AppCompatActivity() {
    private lateinit var btnStart: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemUI(this)
        setContentView(R.layout.activity_launch)
        initComponents()
        initListeners()
    }
    private fun initComponents(){
        btnStart = findViewById(R.id.btn_start)
    }
    private fun initListeners(){
        btnStart.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}