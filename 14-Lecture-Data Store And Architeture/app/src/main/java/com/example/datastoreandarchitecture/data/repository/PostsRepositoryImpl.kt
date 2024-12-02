package com.example.datastoreandarchitecture.data.repository

import com.example.datastoreandarchitecture.core.NetworkCallHelper
import com.example.datastoreandarchitecture.core.OperationStatus
import com.example.datastoreandarchitecture.core.map
import com.example.datastoreandarchitecture.data.remote.RetrofitInstance
import com.example.datastoreandarchitecture.data.toPost
import com.example.datastoreandarchitecture.domain.model.Post
import com.example.datastoreandarchitecture.domain.repository.PostsRepository

class PostsRepositoryImpl : PostsRepository {

    private val postService = RetrofitInstance.postService

    // get all post
    override suspend fun getPostList(): OperationStatus<List<Post>> {
        return NetworkCallHelper.safeApiCall {
            postService.getPostsList()
        }.map { postDtoList ->
            postDtoList.map { postDto ->
                postDto.toPost()
            }
        }
    }

    // get post by id
    override suspend fun getPostById(id: Int): OperationStatus<Post> {
        return NetworkCallHelper.safeApiCall {
            postService.getPostById(id)
        }.map { postDto ->
            postDto.toPost()
        }
    }
}