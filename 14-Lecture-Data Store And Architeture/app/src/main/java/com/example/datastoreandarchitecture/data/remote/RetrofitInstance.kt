package com.example.datastoreandarchitecture.data.remote

import com.example.datastoreandarchitecture.data.remote.service.PostService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val postService = retrofit.create(PostService::class.java)
}