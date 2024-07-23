package com.example.user_recyclerview.viewmodel.adduser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.user_recyclerview.model.repository.UserRepository

class AddUserViewModelFactory(private val userRepository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddUserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AddUserViewModel(userRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


