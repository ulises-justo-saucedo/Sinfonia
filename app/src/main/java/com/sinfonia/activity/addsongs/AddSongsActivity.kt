package com.sinfonia.activity.addsongs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sinfonia.R
import com.sinfonia.activity.hideSystemUI
import com.sinfonia.activity.launch.FirstActivity
import com.sinfonia.files.AppFilesManager
import java.io.File

class AddSongsActivity : AppCompatActivity() {
    private lateinit var appFilesManager: AppFilesManager
    private lateinit var songs: List<File>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemUI(this)
        setContentView(R.layout.activity_add_songs)
        initComponents()
    }
    private fun initComponents(){
        appFilesManager = AppFilesManager(this)
        songs = appFilesManager.getAllUserSongsInDownloadsFolder()
    }
}