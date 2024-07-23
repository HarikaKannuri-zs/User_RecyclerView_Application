package com.example.user_recyclerview.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.user_recyclerview.R
import androidx.activity.viewModels
import com.example.user_recyclerview.viewmodel.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainActivityViewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
