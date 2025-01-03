package com.example.lecturedependency.di

import com.example.lecturedependency.data.repository.TestRepositoryImpl
import com.example.lecturedependency.domain.TestRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::TestRepositoryImpl) bind TestRepository::class
}