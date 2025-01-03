package com.example.lecturedependency.di

import com.example.lecturedependency.data.remote.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    // Retrofit
    single {
        Retrofit.Builder()
            .baseUrl("https://api.example.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // create service
    single {
        get<Retrofit>().create(ApiService::class.java)
    }
}