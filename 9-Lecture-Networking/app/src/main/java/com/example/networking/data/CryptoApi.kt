package com.example.networking.data

import retrofit2.Response
import retrofit2.http.GET

// ------- Create API Interface ----------
interface CryptoApi {
    @GET("coins")
    suspend fun getCryptoList(): Response<List<CryptoData>>
}