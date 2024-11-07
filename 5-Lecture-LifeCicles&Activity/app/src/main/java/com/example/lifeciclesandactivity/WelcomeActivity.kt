package com.example.lifeciclesandactivity

import android.os.Bundle
import android.util.Log.d
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)

        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            finish()
        }
    }

}
