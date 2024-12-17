package com.example.coctailsapplication.data.remote

import com.example.coctailsapplication.data.remote.dto.DrinksListDto
import com.example.coctailsapplication.domain.model.DrinksList

fun DrinksListDto.toDrinkList() = DrinksList(
    drinks = drinks?.map { it.toDrink() }
)

fun DrinksListDto.DrinkDto.toDrink() = DrinksList.Drink(
    id = id,
    name = name,
    category = category,
    instructions = instructions,
    imageUrl = imageUrl
)