package com.example.datastoreandarchitecture.data.remote.service

import com.example.datastoreandarchitecture.data.remote.dto.PostDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {

    @GET("posts")
    suspend fun getPostsList(): Response<List<PostDto>>

    @GET("posts/{postId}")
    suspend fun getPostById(@Path("postId") id: Int): Response<PostDto>

}