package com.example.user_recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewUserFragment : Fragment() {

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
            layoutManager = LinearLayoutManager(requireContext())
            adapter = userAdapter
        }
        addButton = view.findViewById(R.id.addButton)
        addButton.setOnClickListener {
            val addUserFragment = AddUserFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, addUserFragment)
                .addToBackStack(null)
                .commit()
        }
        return view
    }

    override fun onResume() {
        super.onResume()
        val mainActivity = activity as? MainActivity
        userAdapter.setUserData(mainActivity?.userList ?: emptyList())
    }

}

