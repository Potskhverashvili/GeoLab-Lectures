package com.example.datastoreandarchitecture.data

import com.example.datastoreandarchitecture.data.remote.dto.PostDto
import com.example.datastoreandarchitecture.domain.model.Post

// Extension Mapper
fun PostDto.toPost() = Post(
    userId = userId,
    id = id,
    title = title,
    body = body
)