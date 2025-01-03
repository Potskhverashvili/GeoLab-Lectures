package com.example.lecturedependency.domain

interface TestRepository {
    suspend fun getSomeData()
}