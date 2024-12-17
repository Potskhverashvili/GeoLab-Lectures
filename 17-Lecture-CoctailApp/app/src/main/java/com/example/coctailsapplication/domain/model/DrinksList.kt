package com.example.coctailsapplication.domain.model

data class DrinksList(
    val drinks: List<Drink>?,
) {
    data class Drink(
        val id: String?,
        val name: String?,
        val category: String?,
        val instructions: String?,
        val imageUrl: String,
    )
}
