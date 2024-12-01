package com.example.datastoreandarchitecture.data.remote.dto

// DTO - Data Transfer Object
data class PostDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,
)
