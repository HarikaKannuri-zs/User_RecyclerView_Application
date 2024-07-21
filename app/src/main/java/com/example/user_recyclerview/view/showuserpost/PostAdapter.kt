package com.example.user_recyclerview.view.showuserpost

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.user_recyclerview.R
import com.example.user_recyclerview.model.remote.userpostdata.UserPosts

class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    private val posts = mutableListOf<UserPosts>()
    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.postTitleView)
        val url: ImageView = itemView.findViewById(R.id.imageView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val postItemView = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(postItemView)
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentPost = posts[position]
        holder.title.text = currentPost.title
        Glide.with(holder.itemView.context).load(currentPost.url).into(holder.url)
    }
    override fun getItemCount(): Int {
        return posts.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setPostData(newPosts: List<UserPosts>) {
        posts.clear()
        posts.addAll(newPosts)
        notifyDataSetChanged()
    }
}

