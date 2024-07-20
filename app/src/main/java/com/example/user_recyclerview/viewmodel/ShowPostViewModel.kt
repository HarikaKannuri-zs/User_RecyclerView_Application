package com.example.user_recyclerview.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.user_recyclerview.model.remote.RetrofitImplementation
import com.example.user_recyclerview.model.remote.userpostdata.UserPosts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowPostViewModel : ViewModel() {
    fun postAPICall(onResult: (List<UserPosts>) -> Unit) {
        val api = RetrofitImplementation().retroObj()
        api.showPosts().enqueue(object :
            Callback<List<UserPosts>> {
            override fun onResponse(
                call: Call<List<UserPosts>>,
                response: Response<List<UserPosts>>
            ) {
                if (response.isSuccessful) {
                    val posts = response.body() ?: emptyList()
                    onResult(posts)
                }
            }
            override fun onFailure(call: Call<List<UserPosts>>, t: Throwable) {
                Log.d("CHECK", "Failed to load the posts")
            }
        }
        )
    }
}
