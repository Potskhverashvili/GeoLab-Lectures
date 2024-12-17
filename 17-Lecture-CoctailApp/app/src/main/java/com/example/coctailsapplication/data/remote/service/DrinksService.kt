package com.example.coctailsapplication.data.remote.service

import com.example.coctailsapplication.data.remote.dto.DrinksListDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinksService {
    @GET("search.php")
    suspend fun getDrinks(
        @Query("s") drinkName: String,
    ): Response<DrinksListDto>
}