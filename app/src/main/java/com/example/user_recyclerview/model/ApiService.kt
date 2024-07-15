package com.example.user_recyclerview.model

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUser() : Call<List<UserResponse>>
}