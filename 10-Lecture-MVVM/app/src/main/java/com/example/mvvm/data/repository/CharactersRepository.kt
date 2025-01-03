package com.example.mvvm.data.repository

import com.example.mvvm.data.api.RetrofitInstance
import com.example.mvvm.data.model.CharactersList

class CharactersRepository {
    val api = RetrofitInstance.getRickAndMortyApi()

    suspend fun getCharactersList(): CharactersList? {
        return try {
            val charactersResponse = RetrofitInstance.getRickAndMortyApi().getCharacterList()
            charactersResponse.body()
        } catch (error: Exception) {
            null
        }
    }
}