package com.example.networking.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// ------- Create Retrofit Instance ----------
fun createRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.coinpaprika.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}