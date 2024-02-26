package com.sinfonia.files

import android.app.Activity
import android.media.MediaPlayer
import android.net.Uri
import android.os.Environment
import com.sinfonia.activity.main.recyclerview.song.Song

class AppSongsManager(private val context: Activity) {
    private val downloadFile =
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
    lateinit var songs: MutableList<Song>
    private val regexMP3 = Regex("^.+\\.mp3$")
    fun refreshSongs() {
        songs = getAllUserSongsInDownloadsFolder()
    }

    private fun getAllUserSongsInDownloadsFolder(): MutableList<Song> {
        val files = mutableListOf<Song>()
        for (file in downloadFile.listFiles()!!) {
            if (regexMP3.matches(file.name)){
                files.add(Song(file, MediaPlayer.create(context, Uri.fromFile(file))))
            }
        }
        return files
    }

    fun userHasSongs(): Boolean = songs.isNotEmpty()
}