package com.sinfonia.files

import android.app.Activity
import android.media.MediaPlayer
import android.net.Uri
import android.os.Environment
import android.util.Log
import com.sinfonia.activity.main.recyclerview.song.Song
import java.io.File

class AppSongsManager(private val context: Activity) {
    private val musicFolder =
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)
    private val downloadFolder =
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
    val songs = mutableListOf<Song>()
    private val regexMP3 = Regex("^.+\\.mp3$")
    fun refreshSongs() {
        //songs = getAllSongs()
        if(!downloadFolder.exists()){
            downloadFolder.mkdir()
        }
        if(!musicFolder.exists()){
            musicFolder.mkdir()
        }
        songs.clear()
        getAllSongsFromFolder(musicFolder,songs)
        getAllSongsFromFolder(downloadFolder,songs)
    }
    private fun getAllSongsFromFolder(folder: File,songsList: MutableList<Song>){
        for (file in folder.listFiles()!!) {
            if (regexMP3.matches(file.name)){
                songsList.add(Song(file, MediaPlayer.create(context, Uri.fromFile(file))))
            }
        }
    }
    fun userHasSongs(): Boolean = songs.isNotEmpty()
}