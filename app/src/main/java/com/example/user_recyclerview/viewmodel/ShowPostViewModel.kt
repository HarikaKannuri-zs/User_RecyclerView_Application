package com.example.user_recyclerview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.user_recyclerview.model.local.userposts.Posts
import com.example.user_recyclerview.model.repository.PostRepository
import kotlinx.coroutines.launch

class ShowPostViewModel(
    private val postRepository: PostRepository
) : ViewModel() {
    val posts : LiveData<List<Posts>> = postRepository.observePosts()
    fun fetchPost() {
        viewModelScope.launch {
            postRepository.fetchPosts()
        }
    }

    fun toggleFav(postId: Int) {
        viewModelScope.launch {
            postRepository.toggleFav(postId)
        }
    }
}

