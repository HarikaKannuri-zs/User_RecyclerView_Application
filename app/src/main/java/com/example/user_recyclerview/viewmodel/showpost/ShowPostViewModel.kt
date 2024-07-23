package com.example.user_recyclerview.viewmodel.showpost

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import com.example.user_recyclerview.model.local.userposts.Posts
import com.example.user_recyclerview.model.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShowPostViewModel @Inject constructor(
    private val postRepository: PostRepository) : ViewModel() {
    val posts : LiveData<List<Posts>> = postRepository.observePosts()
    fun fetchPosts() {
        viewModelScope.launch {
            postRepository.fetchPosts()
        }
    }
    fun observePost(): LiveData<List<Posts>> = postRepository.observePosts()
    fun toggleFav(postId: Int) {
        viewModelScope.launch {
            postRepository.toggleFav(postId)
        }
    }
}



