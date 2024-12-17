package com.example.coctailsapplication.di

import androidx.room.Room
import com.example.coctailsapplication.data.local.DrinksDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            DrinksDataBase::class.java,
            "drinks_database"
        ).build()
    }

    single {
        get<DrinksDataBase>().drinksDao
    }
}