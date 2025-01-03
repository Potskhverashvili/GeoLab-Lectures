package com.example.mvvm.data.api

import com.example.mvvm.data.model.CharactersList
import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("character")
    suspend fun getCharacterList() : Response<CharactersList>
}