package com.example.user_recyclerview.viewmodel.adduser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.user_recyclerview.model.local.userdata.User
import com.example.user_recyclerview.model.repository.UserRepository
import kotlinx.coroutines.launch

class AddUserViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun insertUser(user: User) {
        viewModelScope.launch {
            userRepository.insertUser(user)
        }
    }
}
