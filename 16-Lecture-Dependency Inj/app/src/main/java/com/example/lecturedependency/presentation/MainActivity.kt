package com.example.lecturedependency.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log.d
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lecturedependency.R
import com.example.lecturedependency.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.java.KoinJavaComponent.inject

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()
    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        viewModel.getData()
    }
}
