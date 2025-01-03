package com.example.lecturedependency.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("some/endpoint")
    suspend fun getSomeData(): Response<Unit>
}