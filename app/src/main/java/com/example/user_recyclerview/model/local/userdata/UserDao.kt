package com.example.user_recyclerview.model.local.userdata

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User)
    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>
}