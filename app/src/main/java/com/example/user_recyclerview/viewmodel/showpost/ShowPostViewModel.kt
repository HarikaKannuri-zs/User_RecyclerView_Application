package com.example.user_recyclerview.viewmodel.showpost

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.user_recyclerview.model.local.userposts.Posts
import com.example.user_recyclerview.model.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShowPostViewModel(
    private val postRepository: PostRepository
) : ViewModel() {
    val posts : LiveData<List<Posts>> = postRepository.observePost()
    fun fetchPost() {
        viewModelScope.launch(Dispatchers.IO) {
            postRepository.fetchPosts()
        }
    }
    fun toggleFav(postId: Int) {
        viewModelScope.launch {
            postRepository.toggleFav(postId)
        }
    }
}
