package com.example.user_recyclerview.model.repository

import com.example.user_recyclerview.model.local.userdata.User
import com.example.user_recyclerview.model.local.userdata.UserDao

class UserRepository(private val userDao: UserDao) {
    fun insertUser(user: User){
        userDao.insertUser(user)
    }
}