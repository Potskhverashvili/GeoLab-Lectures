package com.example.coctailsapplication.di

import com.example.coctailsapplication.data.repository.DrinksRepositoryImpl
import com.example.coctailsapplication.domain.repository.DrinksRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::DrinksRepositoryImpl) bind DrinksRepository::class
}