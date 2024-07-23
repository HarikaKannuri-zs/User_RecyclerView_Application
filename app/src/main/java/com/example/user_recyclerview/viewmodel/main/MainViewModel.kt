package com.example.user_recyclerview.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.user_recyclerview.model.remote.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val apiService: ApiService): ViewModel() {
    private val _showToastLD = MutableLiveData<String>()
    val showToastLD: LiveData<String> = _showToastLD
    fun fetchUsers() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val response = apiService.getUser()
            if(response.isSuccessful) {
                response.body()?.let { users ->
                    users.getOrNull(0)?.let {
                        _showToastLD.postValue(it.name + "" + it.email)
                    } ?: _showToastLD.postValue("Something went wrong")
                } ?: _showToastLD.postValue("Something went wrong")
            } else {
                _showToastLD.postValue("Something went wrong")
            }
        } catch (e: Exception) {
            _showToastLD.postValue("${e.message}")
        }
    }
}