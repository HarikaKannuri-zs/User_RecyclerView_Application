package com.example.user_recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.user_recyclerview.model.remote.RetrofitImplementation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        makeAPICall()
    }
    private val api = RetrofitImplementation().retroObj()
    private fun makeAPICall() {
        lifecycleScope.launch {
            val users = withContext(Dispatchers.IO) {
                api.getUser().execute().body()
            }
            Toast.makeText(this@MainActivity, "${users?.getOrNull(1)?.name}", Toast.LENGTH_SHORT).show()
        }
    }
}
