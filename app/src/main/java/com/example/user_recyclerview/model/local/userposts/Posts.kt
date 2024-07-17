package com.example.user_recyclerview.model.local.userposts

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Posts(
    @PrimaryKey
    var id : Int,
    var title  : String,
    var url : String,
    var isFavourite : Boolean = false
)