package com.example.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.roomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        // ---------------------------- Shared Preferences -------------------------
        /* val preferences = getSharedPreferences("shared_preferences", MODE_PRIVATE)
         binding.countTextView.text = preferences.getInt("key_count", 0).toString()
         binding.plusBtn.setOnClickListener {
             val currentCount = preferences.getInt("key_count", 0)
             preferences.edit().putInt("key_count", currentCount + 1).apply()
             binding.countTextView.text = preferences.getInt("key_count", 0).toString()
         }*/
    }
}