package com.example.user_recyclerview.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.user_recyclerview.model.local.userdata.User
import com.example.user_recyclerview.model.local.UserDatabase

class AddUserViewModel(application: Application) : AndroidViewModel(application) {
    private val userDao = UserDatabase.getDatabase(application).userDao()
    fun insertUser(user: User) {

        userDao.insertUser(user)
    }
}
