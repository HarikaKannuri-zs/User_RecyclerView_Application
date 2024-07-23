package com.example.user_recyclerview.viewmodel.showpost

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.user_recyclerview.model.repository.PostRepository

class ShowPostViewModelFactory(private val postRepository: PostRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShowPostViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ShowPostViewModel(postRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
