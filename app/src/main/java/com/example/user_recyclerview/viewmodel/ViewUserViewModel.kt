package com.example.user_recyclerview.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.user_recyclerview.model.local.User
import com.example.user_recyclerview.model.local.UserDatabase

class ViewUserViewModel(application: Application) : AndroidViewModel(application) {
    val getAllUsers: List<User>
    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        getAllUsers = userDao.getAllUsers()
    }
}