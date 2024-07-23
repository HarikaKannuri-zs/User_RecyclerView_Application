package com.example.user_recyclerview.viewmodel.viewuser

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.user_recyclerview.model.local.userdata.User
import com.example.user_recyclerview.model.local.userdata.UserDao
import com.example.user_recyclerview.model.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ViewUserViewModel @Inject constructor(private val userDao: UserDao) : ViewModel() {
    val users : LiveData<List<User>> = userDao.getAllUsers()
    init{
        getAllUsers()
    }
    private fun getAllUsers() {
        viewModelScope.launch{
            withContext(Dispatchers.IO){
            }
        }
    }
}
