package com.example.user_recyclerview.viewmodel.showpost

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import com.example.user_recyclerview.model.local.userposts.Posts
import com.example.user_recyclerview.model.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShowPostViewModel(
    private val postRepository: PostRepository
) : ViewModel() {
    val posts : LiveData<List<Posts>> = postRepository.observePost()
    fun fetchPost() {
        viewModelScope.launch(Dispatchers.IO) {
            postRepository.fetchPosts()
@HiltViewModel
class ShowPostViewModel @Inject constructor(
    private val postRepository: PostRepository) : ViewModel() {

    fun fetchPost(onResult: (List<Posts>) -> Unit) {
        viewModelScope.launch {
//            val posts = postRepository.fetchPosts()
//            onResult(posts)
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



