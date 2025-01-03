package com.example.mvvm.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.data.model.CharactersList
import com.example.mvvm.data.repository.CharactersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CharactersViewModel : ViewModel() {

    // ---- Init ----
    init {
        getCharacters()
    }

    // --- Repo injection---
    private val characterRepository = CharactersRepository()


    val charactersFlow = MutableStateFlow<List<CharactersList.CharacterItem>>(emptyList())


    // ------- Get Characters ---------
    private fun getCharacters() = viewModelScope.launch {
        val characters = characterRepository.getCharactersList()?.results ?: emptyList()
        charactersFlow.emit(characters)
    }
}

