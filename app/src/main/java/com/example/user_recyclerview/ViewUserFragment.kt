package com.example.user_recyclerview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewUserFragment : Fragment(), AddUserListener {

    private val userList = mutableListOf<User>()
    private lateinit var addButton: Button
    private lateinit var userRecyclerView: RecyclerView
    private val userAdapter: UserAdapter by lazy {
        UserAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_user, container, false)
        userRecyclerView = view.findViewById(R.id.userRecyclerView)
        userRecyclerView.apply {
            userRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            adapter = userAdapter
        }
        addButton = view.findViewById(R.id.addButton)
        addButton.setOnClickListener {
            val addUserFragment = AddUserFragment()
            addUserFragment.setAddUserListener(this@ViewUserFragment)
            val ft = parentFragmentManager.beginTransaction()
            ft.replace(R.id.fragment_container_view, addUserFragment)
            ft.addToBackStack(null)
            ft.commit()
        }

        return view
    }

    override fun onUserAdded(user: User) {
        userList.add(0,user)
        userAdapter.setUserData(userList)
        Log.d("USERLIST"," Added : "+userList.size)
    }
}

interface AddUserListener {
    fun onUserAdded(user: User)
}
