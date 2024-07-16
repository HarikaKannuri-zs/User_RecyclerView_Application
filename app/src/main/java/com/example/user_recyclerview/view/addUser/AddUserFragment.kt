package com.example.user_recyclerview.view.addUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.user_recyclerview.R
import com.example.user_recyclerview.model.local.User
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
        userAddButton.setOnClickListener {
            addUserViewModel = ViewModelProvider(this@AddUserFragment).get(AddUserViewModel::class.java)
            val userId = userIdEditText.text.toString()
            val userName = userNameEditText.text.toString()
            val userPhone = userPhoneEditText.text.toString()
            if (userId.isNotBlank() && userName.isNotBlank() && userPhone.isNotBlank()) {
                val user = User(userId, userName, userPhone)
                addUserViewModel.insertUser(user)
                Toast.makeText(requireContext(), "User added Successfully", Toast.LENGTH_SHORT)
                    .show()
                parentFragmentManager.popBackStack()
            } else {
                Toast.makeText(requireContext(), "Enter all the details", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}
