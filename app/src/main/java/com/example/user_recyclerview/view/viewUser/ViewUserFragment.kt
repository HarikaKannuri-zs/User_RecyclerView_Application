package com.example.user_recyclerview.view.viewUser

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.user_recyclerview.R
import com.example.user_recyclerview.model.local.UserDatabase
import com.example.user_recyclerview.view.MainActivity
import com.example.user_recyclerview.view.adapter.UserAdapter
import com.example.user_recyclerview.view.addUser.AddUserFragment
import com.example.user_recyclerview.view.showuserpost.ShowPostFragment
import com.example.user_recyclerview.viewmodel.viewuser.ViewUserViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels

@AndroidEntryPoint
class ViewUserFragment : Fragment() {
    private lateinit var addButton: Button
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userDatabase: UserDatabase
    private lateinit var postButton: Button
    private lateinit var userAdapter: UserAdapter
    private val viewUserViewModel: ViewUserViewModel by viewModels()

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_user, container, false)
        userRecyclerView = view.findViewById(R.id.userRecyclerView)
        val deleteUser : (String) -> Unit = {
            userId -> viewUserViewModel.deleteUser(userId)
            Toast.makeText(context,"User Deleted",Toast.LENGTH_SHORT).show()
        }
        userAdapter = UserAdapter(deleteUser)
        userRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = userAdapter
        }
        userDatabase = UserDatabase.getDatabase((activity as MainActivity).applicationContext)
        addButton = view.findViewById(R.id.addButton)
        addButton.setOnClickListener {
            loadFragment(AddUserFragment())
        }
        postButton = view.findViewById(R.id.postbutton)
        postButton.setOnClickListener {
            loadFragment(ShowPostFragment())
        }
        return view
    }
    private fun loadFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().replace(R.id.fragment_container_view, fragment)
            .addToBackStack(null).commit()
    }
    override fun onResume() {
        super.onResume()
        viewUserViewModel.users.observe(viewLifecycleOwner) { users ->
            userAdapter.setUserData(users)
        }
    }
}

