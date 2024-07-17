package com.example.user_recyclerview.model.local.userdata

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(
    @PrimaryKey
    @ColumnInfo(name = "UserId")
    val userId: String,
    @ColumnInfo(name = "UseName")
    var userName: String,
    @ColumnInfo(name = "UserPhone")
    var userPhone: String
)

