package com.example.datastoreandarchitecture.data.repository

import com.example.datastoreandarchitecture.core.OperationStatus
import com.example.datastoreandarchitecture.data.remote.RetrofitInstance
import com.example.datastoreandarchitecture.data.toPost
import com.example.datastoreandarchitecture.domain.model.Post
import com.example.datastoreandarchitecture.domain.repository.PostsRepository

class PostsRepositoryImpl : PostsRepository {

    private val postService = RetrofitInstance.postService

    override suspend fun getPostList(): OperationStatus<List<Post>> {
        return try {
            OperationStatus.Success(
                postService.getPostsList()
                    .body()!!.map { postDto ->
                        postDto.toPost()
                    }
            )
        } catch (e: Exception) {
            OperationStatus.Failure(e)
        }
    }

    override suspend fun getPostById(id: Int): OperationStatus<Post> {
        return try {
            OperationStatus.Success(
                postService.getPostById(id)
                    .body()!!
                    .toPost()
            )
        } catch (e: Exception) {
            OperationStatus.Failure(e)
        }
    }
}