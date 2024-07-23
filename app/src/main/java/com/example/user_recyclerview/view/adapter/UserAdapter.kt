package com.example.user_recyclerview.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.user_recyclerview.R
import com.example.user_recyclerview.model.local.userdata.User

class UserAdapter(private val deleteUser:(String) ->Unit) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private var users = mutableListOf<User>()
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userNameTextView: TextView = itemView.findViewById(R.id.userNameViewText)
        val userIdTextView: TextView = itemView.findViewById(R.id.userIdViewText)
        val userPhoneTextView: TextView = itemView.findViewById(R.id.userPhoneViewText)
        val deleteButton : Button = itemView.findViewById(R.id.deleteButton)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = users[position]
        holder.userNameTextView.text = currentUser.userName
        holder.userIdTextView.text = currentUser.userId
        holder.userPhoneTextView.text = currentUser.userPhone
        holder.deleteButton.setOnClickListener {
            deleteUser(currentUser.userId)
        }
    }
    override fun getItemCount(): Int {
        return users.size
    }
    fun setUserData(newUsers: List<User>) {
        users = newUsers.toMutableList()
        notifyDataSetChanged()
    }
}
