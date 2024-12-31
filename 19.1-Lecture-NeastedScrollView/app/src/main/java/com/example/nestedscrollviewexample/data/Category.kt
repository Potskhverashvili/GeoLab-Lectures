package com.example.nestedscrollviewexample.data

import java.util.UUID

data class Category(
    val id: String = UUID.randomUUID().toString(),
    val name: String
)