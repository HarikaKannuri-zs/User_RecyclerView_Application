package com.example.user_recyclerview.model.local.userposts

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface PostDao {

    @Insert
    fun insertPost(posts: Posts)

    @Insert
    fun insertPosts(post: List<Posts>)

    @Query("SELECT * from Posts")
    fun showPost():LiveData<List<Posts>>

    @Update
    fun updatePost(posts: Posts)

    @Query("UPDATE Posts SET isFavourite = NOT isFavourite WHERE postId = :postId;")
    fun toggleFav(postId: Int)

}