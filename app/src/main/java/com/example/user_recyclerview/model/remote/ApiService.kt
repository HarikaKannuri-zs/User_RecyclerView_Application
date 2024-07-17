package com.example.user_recyclerview.model.remote

import com.example.user_recyclerview.model.local.userposts.Posts
import com.example.user_recyclerview.model.remote.userdata.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUser() : Call<List<UserResponse>>
    @GET("photos")
    fun showPosts() : Call<List<Posts>>
}