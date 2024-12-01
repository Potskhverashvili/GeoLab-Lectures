package com.example.datastoreandarchitecture.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.datastoreandarchitecture.core.OperationStatus
import com.example.datastoreandarchitecture.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    // private val settingStore by preferencesDataStore("settings")
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /* initViews()
         setListeners()*/


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