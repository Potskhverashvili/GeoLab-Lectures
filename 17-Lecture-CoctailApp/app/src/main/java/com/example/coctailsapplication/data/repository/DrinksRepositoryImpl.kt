package com.example.coctailsapplication.data.repository

import com.example.coctailsapplication.core.safeApiCall
import com.example.coctailsapplication.data.local.dao.DrinksDao
import com.example.coctailsapplication.data.remote.service.DrinksService
import com.example.coctailsapplication.data.remote.toDrinkList
import com.example.coctailsapplication.domain.model.DrinksList
import com.example.coctailsapplication.domain.repository.DrinksRepository

class DrinksRepositoryImpl(
    private val drinksService: DrinksService,
    private val drinksDao: DrinksDao
) : DrinksRepository {
    override suspend fun getDrinks(drinkName: String): Result<DrinksList> {
        return safeApiCall {
            drinksService.getDrinks(drinkName)
        }.map { drinkListDto ->
            drinkListDto.toDrinkList()
        }
    }
}