package com.example.coctailsapplication.di

import com.example.coctailsapplication.presentation.screens.drinks_list.DrinksListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelsModule = module {
    viewModelOf(::DrinksListViewModel)
}