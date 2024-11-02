package com.example.lifeciclesandactivity

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        d("LifeCycle_Log", "onCreate")

        findViewById<Button>(R.id.continueButton).setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
        }

    }

    override fun onStart(){
        super.onStart()
        d("LifeCycle_Log", "onStart")
    }


    override fun onResume() {
        super.onResume()
        d("LifeCycle_Log", "onResume")
    }

    override fun onStop() {
        super.onStop()
        d("LifeCycle_Log", "onStop")
    }

    override fun onPause() {
        super.onPause()
        d("LifeCycle_Log", "onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        d("LifeCycle_Log", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        d("LifeCycle_Log", "onRestart")
    }
}