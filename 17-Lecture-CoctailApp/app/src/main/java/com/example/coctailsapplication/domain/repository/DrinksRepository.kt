package com.example.coctailsapplication.domain.repository

import com.example.coctailsapplication.domain.model.DrinksList

interface DrinksRepository {
    suspend fun getDrinks(drinkName: String): Result<DrinksList>
}