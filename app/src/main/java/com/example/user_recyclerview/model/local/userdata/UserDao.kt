package com.example.user_recyclerview.model.local.userdata

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)
    @Query("SELECT * FROM user")
    fun getAllUsers(): LiveData<List<User>>
}