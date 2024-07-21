package com.example.user_recyclerview.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.user_recyclerview.model.local.User
import com.example.user_recyclerview.model.local.UserDatabase

class ViewUserViewModel(application: Application) : AndroidViewModel(application) {
        private val userDao = UserDatabase.getDatabase(application).userDao()
        val getAllUsers: List<User>
        get() = userDao.getAllUsers()
}
