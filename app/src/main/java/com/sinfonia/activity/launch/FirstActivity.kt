package com.sinfonia.activity.launch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.sinfonia.R
import com.sinfonia.activity.main.MainActivity

class FirstActivity : AppCompatActivity() {
    private lateinit var btnStart: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideAndroidUi()
        setContentView(R.layout.activity_launch)
        initComponents()
        initListeners()
    }
    private fun hideAndroidUi(){
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )
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