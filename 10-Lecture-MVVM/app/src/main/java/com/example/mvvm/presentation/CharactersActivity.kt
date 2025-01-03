package com.example.mvvm.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.mvvm.databinding.ActivityCharactersBinding
import kotlinx.coroutines.launch

class CharactersActivity : AppCompatActivity() {

    // ----- View Model ------
    private val viewModel by viewModels<CharactersViewModel>()

    // ---- Binding ------
    private val binding by lazy { ActivityCharactersBinding.inflate(layoutInflater) }

    // ---- Adapter Instance -----
    private val characterAdapter = CharacterAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecycler()
        setCollectors()
    }

    // ----- Recycler View ------
    private fun initRecycler() {
        binding.characterRecyclerView.adapter = characterAdapter
    }

    // ----- Set Collect -----
    private fun setCollectors() {
        lifecycleScope.launch {
            viewModel.charactersFlow.collect { charactersList ->
                characterAdapter.setCharactersList(charactersList)
            }
        }
    }
}
