package com.example.coctailsapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coctailsapplication.data.local.dao.DrinksDao
import com.example.coctailsapplication.data.local.dbo.DrinkDbo

@Database(entities = [DrinkDbo::class], version = 1)
abstract class DrinksDataBase : RoomDatabase() {
    abstract val drinksDao: DrinksDao
}