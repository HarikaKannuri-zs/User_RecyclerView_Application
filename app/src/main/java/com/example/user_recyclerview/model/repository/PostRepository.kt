package com.example.user_recyclerview.model.repository

import com.example.user_recyclerview.model.local.userposts.PostDao
import com.example.user_recyclerview.model.local.userposts.Posts
import com.example.user_recyclerview.model.remote.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostRepository(private val apiService: ApiService, private val postDao: PostDao) {
    suspend fun fetchPosts(): List<Posts> {
        return withContext(Dispatchers.IO) {
            val response = apiService.showPosts()
            if (response.isSuccessful) {
                response.body()?.let { posts ->
                    postDao.insertPosts(posts)
                    posts
                } ?: emptyList()
            } else {
                emptyList()
            }
        }
    }
    fun observePosts() = postDao.showPost()
    suspend fun toggleFav(postId: Int) {
        withContext(Dispatchers.IO) {
            postDao.toggleFav(postId)
        }
    }
}
