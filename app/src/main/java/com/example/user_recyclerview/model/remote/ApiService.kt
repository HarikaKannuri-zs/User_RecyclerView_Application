package com.example.user_recyclerview.model.remote

import com.example.user_recyclerview.model.remote.userdata.UserResponse
import com.example.user_recyclerview.model.remote.userpostdata.UserPosts
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUser() : Call<List<UserResponse>>
    @GET("photos")
    fun showPosts() : Call<List<UserPosts>>
}