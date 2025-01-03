package com.example.lecturedependency.data.repository

import com.example.lecturedependency.data.remote.ApiService
import com.example.lecturedependency.domain.TestRepository

class TestRepositoryImpl(
    private val apiService: ApiService,
) : TestRepository {

    override suspend fun getSomeData() {

    }
}