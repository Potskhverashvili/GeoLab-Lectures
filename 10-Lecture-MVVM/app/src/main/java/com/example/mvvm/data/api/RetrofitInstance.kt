package com.example.mvvm.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getRickAndMortyApi(): RickAndMortyApi {
        return getRetrofit().create(RickAndMortyApi::class.java)
    }
}