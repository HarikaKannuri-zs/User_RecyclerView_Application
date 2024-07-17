package com.example.user_recyclerview.model.repository

import androidx.lifecycle.LiveData
import com.example.user_recyclerview.model.local.userposts.PostDao
import com.example.user_recyclerview.model.local.userposts.Posts
import com.example.user_recyclerview.model.remote.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository(private val apiService: ApiService,private val postDao: PostDao) {

    fun fetchPosts(){
        val posts = apiService.showPosts()
        posts.enqueue(object: Callback<List<Posts>> {
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                 if(response.isSuccessful) {
                     response.body()?.let { posts ->
                         postDao.insertPosts(posts)
                     }
                 }
            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {

            }

        })
    }

    fun observePosts(): LiveData<List<Posts>> = postDao.showPost()
    fun toggleFav(postId: Int) {
       postDao.toggleFav(postId)
    }

}