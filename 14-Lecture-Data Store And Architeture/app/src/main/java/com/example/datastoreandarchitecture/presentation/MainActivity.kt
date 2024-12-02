package com.example.datastoreandarchitecture.presentation

import android.os.Bundle
import android.util.Log.d
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.datastoreandarchitecture.databinding.ActivityMainBinding
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    // private val settingStore by preferencesDataStore("settings")
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val viewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        /* initViews()
         setListeners()*/

        // Posts
        lifecycleScope.launch {
            viewModel.postFlow.collect { posts ->
                d("MyLog", posts.toString())
            }
        }

        // Failures
        lifecycleScope.launch {
            viewModel.showErrorFlow.collect { error ->
                d("MyLog", error.toString())
            }
        }
    }


    // -------------------------- Data Store ---------------------------
    /*
        // Init Views
        private fun initViews() = lifecycleScope.launch {
            val settingsPrefs = settingStore.data.first()
            binding.darkModeSwitch.isChecked = settingsPrefs[darkModeKey] ?: false
            binding.pinLoginSwitch.isChecked = settingsPrefs[pinLoginKey] ?: false
        }

        // Set Listeners
        private fun setListeners() {
            // dark mode
            binding.darkModeSwitch.setOnCheckedChangeListener { _, isSelected ->
                lifecycleScope.launch {
                    settingStore.edit { it[darkModeKey] = isSelected }
                }
            }

            // pin login
            binding.pinLoginSwitch.setOnCheckedChangeListener { _, isSelected ->
                lifecycleScope.launch {
                    settingStore.edit { it[pinLoginKey] = isSelected }
                }
            }
        }

        // Companion Object
        companion object {
            val darkModeKey = booleanPreferencesKey("dark_mode")
            val pinLoginKey = booleanPreferencesKey("pin_login")
        }*/
}