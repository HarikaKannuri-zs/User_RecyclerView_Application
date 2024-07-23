package com.example.user_recyclerview.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.user_recyclerview.R
import androidx.lifecycle.ViewModelProvider
import com.example.user_recyclerview.model.remote.RetrofitImplementation
import com.example.user_recyclerview.viewmodel.main.MainViewModel
import com.example.user_recyclerview.viewmodel.main.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private val api = RetrofitImplementation().retroObj()
    private lateinit var  mainActivityViewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val factory = MainViewModelFactory(api)
        mainActivityViewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        observeMainActivityViewModel()
        mainActivityViewModel.fetchUsers()
    }
    private fun observeMainActivityViewModel() {
        mainActivityViewModel.showToastLD.observe(this) { toastMessage ->
            Toast.makeText(this@MainActivity, toastMessage, Toast.LENGTH_SHORT)
                .show()
        }
    }
}
