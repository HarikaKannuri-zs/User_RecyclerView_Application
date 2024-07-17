package com.example.user_recyclerview.view.showuserpost

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.user_recyclerview.R
import com.example.user_recyclerview.model.local.userposts.Posts
import com.example.user_recyclerview.model.remote.userpostdata.UserPosts

class PostAdapter(
    private val context: Context,
    private val onFavClick: (Int) -> Unit,
):  RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    private val posts = mutableListOf<Posts>()
    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.postTitleView)
        val url : ImageView = itemView.findViewById(R.id.imageView)
        val like: ImageView = itemView.findViewById(R.id.favouriteIcon)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val postItemView = LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false)
        return PostViewHolder(postItemView)
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentPost = posts[position]
        holder.title.text = currentPost.title
        Glide.with(holder.itemView.context)
            .load(currentPost.url)
            .into(holder.url)
            holder.like.setImageDrawable(ContextCompat.getDrawable(context, if(currentPost.isFavourite) R.drawable.liked_icon else  R.drawable.unliked_icon ))

        holder.like.setOnClickListener {
            onFavClick(currentPost.id)
        }
    }
    override fun getItemCount(): Int {
        return posts.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setPostData(newPosts : List<Posts>) {
        posts.clear()
        posts.addAll(newPosts)
        notifyDataSetChanged()
    }
}

