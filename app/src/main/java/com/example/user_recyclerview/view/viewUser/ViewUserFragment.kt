package com.example.user_recyclerview.view.viewUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.user_recyclerview.R
import com.example.user_recyclerview.view.addUser.AddUserFragment
import com.example.user_recyclerview.view.showuserpost.ShowPostFragment
import com.example.user_recyclerview.view.viewUser.adapter.UserAdapter
import com.example.user_recyclerview.viewmodel.ViewUserViewModel

class ViewUserFragment : Fragment() {
    private lateinit var addButton: Button
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var viewUserViewModel: ViewUserViewModel
    private lateinit var userAdapter: UserAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_user, container, false)
        viewUserViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)).get(ViewUserViewModel::class.java)
        userRecyclerView = view.findViewById(R.id.userRecyclerView)
        userAdapter = UserAdapter()
        userRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        userRecyclerView.adapter = userAdapter
        addButton = view.findViewById(R.id.addButton)
        addButton.setOnClickListener {
            val addUserFragment = AddUserFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, addUserFragment)
                .addToBackStack(null)
                .commit()
        }
        val postButton: Button = view.findViewById(R.id.postbutton)
        postButton.setOnClickListener {
            val showPostFragment = ShowPostFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, showPostFragment)
                .addToBackStack(null)
                .commit()
        }
        return view
    }
    override fun onResume() {
        super.onResume()
        setData()
    }
    private fun setData() {
        val users = viewUserViewModel.getAllUsers
        userAdapter.setUserData(users)
    }
}
