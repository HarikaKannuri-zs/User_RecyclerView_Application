package com.example.user_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var userList: List<User> = emptyList()

    fun setUserData(userList: List<User>) {
        this.userList = userList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userIdTextView: TextView = itemView.findViewById(R.id.userIdViewText)
        private val userNameTextView: TextView = itemView.findViewById(R.id.userNameViewText)
        private val userPhoneTextView: TextView = itemView.findViewById(R.id.userPhoneViewText)

        fun bind(user: User) {
            userIdTextView.text = "User Id : ${user.id}"
            userNameTextView.text = "User Name : ${user.userName}"
            userPhoneTextView.text = "User Phone: ${user.userPhone}"
        }
    }
}
