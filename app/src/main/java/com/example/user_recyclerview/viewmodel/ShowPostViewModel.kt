package com.example.user_recyclerview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.user_recyclerview.model.local.userposts.Posts
import com.example.user_recyclerview.model.repository.PostRepository

class ShowPostViewModel(
    private val postRepository: PostRepository
) : ViewModel() {

    init {
        downloadPost()
    }

    private fun downloadPost() {
        postRepository.fetchPosts()
    }

    fun observePost(): LiveData<List<Posts>> = postRepository.observePosts()
    fun toggleFav(postId: Int) {
        postRepository.toggleFav(postId)
    }


}

