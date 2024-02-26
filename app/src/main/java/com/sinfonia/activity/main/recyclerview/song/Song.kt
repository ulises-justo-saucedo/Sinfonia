package com.sinfonia.activity.main.recyclerview.song
import android.media.MediaPlayer
import java.io.File
data class Song(
    var file: File,
    var mediaPlayer: MediaPlayer
)