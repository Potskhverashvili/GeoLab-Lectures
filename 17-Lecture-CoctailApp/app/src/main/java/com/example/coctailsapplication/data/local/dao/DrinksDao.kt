package com.example.coctailsapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.example.coctailsapplication.data.local.dbo.DrinkDbo

@Dao
interface DrinksDao {
    @Insert
    suspend fun saveDrink(drink: DrinkDbo)

    @Delete
    suspend fun deleteDrink(drink: DrinkDbo)
}