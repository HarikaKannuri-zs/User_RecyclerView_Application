package com.example.user_recyclerview.viewmodel.viewuser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.user_recyclerview.model.local.userdata.UserDao
import com.example.user_recyclerview.model.repository.PostRepository

class ViewUserViewModelFactory(private val userDao: UserDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewUserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ViewUserViewModel(userDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
