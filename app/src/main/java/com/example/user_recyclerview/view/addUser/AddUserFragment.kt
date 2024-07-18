package com.example.user_recyclerview.view.addUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.user_recyclerview.R

import com.example.user_recyclerview.viewmodel.AddUserViewModel

class AddUserFragment : Fragment() {
    private lateinit var addUserViewModel : AddUserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_user, container, false)
        val userIdEditText: EditText = view.findViewById(R.id.userIdEditText)
        val userNameEditText: EditText = view.findViewById(R.id.userNameEditText)
        val userPhoneEditText: EditText = view.findViewById(R.id.userPhoneEditText)
        val userAddButton: Button = view.findViewById(R.id.userAddButton)
        addUserViewModel = ViewModelProvider(this@AddUserFragment).get(AddUserViewModel::class.java)
        userAddButton.setOnClickListener {
            val userId = userIdEditText.text.toString()
            val userName = userNameEditText.text.toString()
            val userPhone = userPhoneEditText.text.toString()
            addUserViewModel.validateAddUser(userId,userName,userPhone)
            parentFragmentManager.popBackStack()
        }
        return view
    }
}
