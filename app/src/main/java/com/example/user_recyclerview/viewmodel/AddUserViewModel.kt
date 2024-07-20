package com.example.user_recyclerview.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.example.user_recyclerview.model.local.User
import com.example.user_recyclerview.model.local.UserDatabase

class AddUserViewModel(application: Application) : AndroidViewModel(application) {
    private val userDao = UserDatabase.getDatabase(application).userDao()
        fun validateAddUser(userId : String , userName: String,userPhone : String) =
            if (userId.isNotBlank() && userName.isNotBlank() && userPhone.isNotBlank()) {
                val user = User(userId, userName, userPhone)
                insertUser(user)
                Toast.makeText(getApplication(),"User added Successfully",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(getApplication(),"Enter all the details",Toast.LENGTH_SHORT).show()
            }
        private fun insertUser(user: User) {
            userDao.insertUser(user)
        }
    }
