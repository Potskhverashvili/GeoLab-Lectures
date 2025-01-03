package com.example.datastoreandarchitecture.domain.repository

import com.example.datastoreandarchitecture.core.OperationStatus
import com.example.datastoreandarchitecture.domain.model.Post

interface PostsRepository {

    suspend fun getPostList(): OperationStatus<List<Post>>

    suspend fun getPostById(id: Int): OperationStatus<Post>
}