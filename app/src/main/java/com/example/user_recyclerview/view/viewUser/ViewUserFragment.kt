package com.example.user_recyclerview.view.viewUser

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.user_recyclerview.MainActivity
import com.example.user_recyclerview.R
import com.example.user_recyclerview.model.local.UserDao
import com.example.user_recyclerview.model.local.UserDatabase
import com.example.user_recyclerview.view.addUser.AddUserFragment
import com.example.user_recyclerview.view.showuserpost.ShowPostFragment
import com.example.user_recyclerview.view.viewUser.adapter.UserAdapter

class ViewUserFragment : Fragment() {
    private lateinit var addButton: Button
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userDatabase: UserDatabase
    private lateinit var userDao: UserDao
    private lateinit var postButton: Button
    private val userAdapter: UserAdapter by lazy {
        UserAdapter()
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_user, container, false)
        userRecyclerView = view.findViewById(R.id.userRecyclerView)
        userRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = userAdapter
        }
        userDatabase = UserDatabase.getDatabase((activity as MainActivity).applicationContext)
        userDao = userDatabase.userDao()
        addButton = view.findViewById(R.id.addButton)
        addButton.setOnClickListener {
            val addUserFragment = AddUserFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, addUserFragment)
                .addToBackStack(null)
                .commit()
        }
        postButton = view.findViewById(R.id.postbutton)
        postButton.setOnClickListener{
            val showPostFragment = ShowPostFragment()
            parentFragmentManager.beginTransaction().replace(R.id.fragment_container_view,showPostFragment)
                .addToBackStack(null)
                .commit()
        }
        return view
    }
    private fun setData() {
        val users = userDao.getAllUsers()
        userAdapter.setUserData(users)
    }
    override fun onResume() {
        super.onResume()
        setData()
    }
}

