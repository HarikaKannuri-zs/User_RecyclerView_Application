package com.example.user_recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.user_recyclerview.model.RetrofitImplementation
import com.example.user_recyclerview.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        makeAPICall()
    }
    fun makeAPICall() {
        val api = RetrofitImplementation().retroObj()
        api.getUser().enqueue(object :
            Callback<List<UserResponse>> {
            override fun onResponse(
                call: Call<List<UserResponse>>,
                response: Response<List<UserResponse>>
            ) {
                if (response.isSuccessful) {
                    val result: List<UserResponse>? = response.body()
                    Toast.makeText(
                        this@MainActivity,
                        "${result?.getOrNull(1)?.name}",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(this@MainActivity, "Failure", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<UserResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failure", Toast.LENGTH_SHORT).show()
            }
        }
        )
    }

}
