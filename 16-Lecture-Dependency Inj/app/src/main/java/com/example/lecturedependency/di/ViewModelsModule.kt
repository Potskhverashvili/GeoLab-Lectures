package com.example.lecturedependency.di

import com.example.lecturedependency.presentation.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val viewModelsModule = module {
    viewModelOf(::MainViewModel)
}