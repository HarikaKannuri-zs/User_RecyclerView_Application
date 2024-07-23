package com.example.user_recyclerview.view.addUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.user_recyclerview.R
import com.example.user_recyclerview.model.local.userdata.User
import com.example.user_recyclerview.viewmodel.adduser.AddUserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.fragment.app.viewModels
import com.example.user_recyclerview.model.local.UserDatabase
import com.example.user_recyclerview.model.repository.UserRepository
import com.example.user_recyclerview.viewmodel.adduser.AddUserViewModelFactory

class AddUserFragment : Fragment() {
    private val addUserViewModel : AddUserViewModel by viewModels{
        AddUserViewModelFactory(UserRepository(UserDatabase.getDatabase(requireContext()).userDao()))
    }
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
            val userId = userIdEditText.text.toString()
            val userName = userNameEditText.text.toString()
            val userPhone = userPhoneEditText.text.toString()
            if (userId.isNotBlank() && userName.isNotBlank() && userPhone.isNotBlank()) {
                val user = User(userId, userName, userPhone)
                CoroutineScope(Dispatchers.IO).launch {  addUserViewModel.insertUser(user)}
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
