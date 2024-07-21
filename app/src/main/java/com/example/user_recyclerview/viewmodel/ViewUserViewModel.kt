package com.example.user_recyclerview.viewmodel

import androidx.lifecycle.ViewModel
import com.example.user_recyclerview.model.local.userdata.User
import com.example.user_recyclerview.model.local.userdata.UserDao

class ViewUserViewModel(private val userDao: UserDao) : ViewModel() {
    fun getAllUsers() : List<User>{
        return userDao.getAllUsers()
    }
}
