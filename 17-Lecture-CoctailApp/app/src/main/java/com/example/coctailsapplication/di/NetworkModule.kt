package com.example.coctailsapplication.di

import com.example.coctailsapplication.data.remote.service.DrinksService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single {
        get<Retrofit>().create(DrinksService::class.java)
    }


    // factory -> it creates new instance every time
}