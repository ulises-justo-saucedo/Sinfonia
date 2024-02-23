package com.sinfonia.files

import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class AppFilesManager {
    companion object{
        private val downloadFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        lateinit var songs : MutableList<File>
        private val regexMP3 = Regex("^.+\\.mp3$")
        fun refreshSongs(){
            songs = getAllUserSongsInDownloadsFolder()
        }
        private fun getAllUserSongsInDownloadsFolder() : MutableList<File> {
            val files = mutableListOf<File>()
            for(file in downloadFile.listFiles()!!){
                if(regexMP3.matches(file.name)) files.add(file)
            }
            return files
        }
        fun userHasSongs(): Boolean = songs.isNotEmpty()
    }
}