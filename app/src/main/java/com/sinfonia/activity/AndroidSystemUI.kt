package com.sinfonia.activity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
fun hideSystemUI(activity: AppCompatActivity){
    activity.window.decorView.systemUiVisibility = (
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            )
}