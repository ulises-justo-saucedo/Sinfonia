package com.sinfonia.files

import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class AppFilesManager {
    companion object{
        private val downloadFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        fun initFolders(activity: AppCompatActivity){
            var appMusicFile = activity.getExternalFilesDir("music")!!
            if(!appMusicFile.exists()) appMusicFile.mkdir()
        }
        fun getAllUserSongsInDownloadsFolder() : List<File> {
            var files = mutableListOf<File>()
            var validMP3FilePattern = "^.+\\.mp3$"
            var regex = Regex(validMP3FilePattern)
            for(file in downloadFile.listFiles()!!){
                if(regex.matches(file.name)) files.add(file)
            }
            return files
        }
    }
}