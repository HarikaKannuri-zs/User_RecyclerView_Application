package com.example.user_recyclerview.model.repository

import androidx.lifecycle.LiveData
import com.example.user_recyclerview.model.local.userposts.PostDao
import com.example.user_recyclerview.model.local.userposts.Posts
import com.example.user_recyclerview.model.remote.ApiService

class PostRepository(private val apiService: ApiService, private val postDao: PostDao) {
    fun observePost() : LiveData<List<Posts>>{
        return postDao.showPost()
    }
    suspend fun fetchPosts() {
        val response = apiService.showPosts()
        if(response.isSuccessful) {
            response.body()?.let { posts ->
                postDao.insertPosts(posts)
            }
        }
    }
    suspend fun toggleFav(postId: Int) {
        postDao.toggleFav(postId)
    }
}
