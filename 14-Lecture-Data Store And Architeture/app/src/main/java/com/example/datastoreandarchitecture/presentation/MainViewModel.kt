package com.example.datastoreandarchitecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.datastoreandarchitecture.core.onFailure
import com.example.datastoreandarchitecture.core.onSuccess
import com.example.datastoreandarchitecture.data.repository.PostsRepositoryImpl
import com.example.datastoreandarchitecture.domain.model.Post
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    // Repo inj
    private val postsRepository = PostsRepositoryImpl()

    // Flows
    val postFlow = MutableStateFlow(emptyList<Post>())
    val showErrorFlow = MutableSharedFlow<Exception>()

    // init
    init {
        getPosts()
    }

    // get Posts
    private fun getPosts() = viewModelScope.launch {
        postsRepository.getPostList()
            .onSuccess { posts ->
                postFlow.emit(posts)
            }.onFailure { exception ->
                showErrorFlow.emit(exception)
            }

    }
}

