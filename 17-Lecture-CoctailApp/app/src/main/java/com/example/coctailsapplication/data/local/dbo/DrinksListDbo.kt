package com.example.coctailsapplication.data.local.dbo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drinks_table")
data class DrinkDbo(
    @PrimaryKey
    val id: String,
    val name: String?,
    val category: String?,
    val instructions: String?,
    val imageUrl: String,
)
