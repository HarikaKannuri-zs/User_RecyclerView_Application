package com.example.user_recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.user_recyclerview.model.remote.RetrofitImplementation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        makeAPICall()
    }
    private val api = RetrofitImplementation().retroObj()
//    private fun makeAPICall() {
//        api.getUser().enqueue(object :
//            Callback<List<UserResponse>> {
//            override fun onResponse(
//                call: Call<List<UserResponse>>,
//                response: Response<List<UserResponse>>
//            ) {
//                if (response.isSuccessful) {
//                    val result: List<UserResponse>? = response.body()
//                    Toast.makeText(this@MainActivity, "${result?.getOrNull(1)?.name}", Toast.LENGTH_SHORT).show()
//                } else {
//                    Toast.makeText(this@MainActivity, "Failure", Toast.LENGTH_SHORT).show()
//                }
//            }
//            override fun onFailure(call: Call<List<UserResponse>>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "Failure", Toast.LENGTH_SHORT).show()
//            }
//        }
//        )
//    }
private fun makeAPICall() {
    lifecycleScope.launch {
        try {
            val users = withContext(Dispatchers.IO) {
                api.getUser().execute().body()
            }
            Toast.makeText(this@MainActivity, "${users?.getOrNull(1)?.name}", Toast.LENGTH_SHORT).show()
        } catch (e: HttpException) {
            Toast.makeText(this@MainActivity, "Network Error", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, "Error: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
        }
    }
}

}
