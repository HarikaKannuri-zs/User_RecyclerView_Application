package com.example.user_recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class AddUserFragment : Fragment() {

   private var addUserListener: AddUserListener?= null


   fun setAddUserListener(addUserListener: AddUserListener) {
       this.addUserListener = addUserListener
   }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_user, container, false)

        val userIdEditText: EditText = view.findViewById(R.id.userIdEditText)
        val userNameEditText: EditText = view.findViewById(R.id.userNameEditText)
        val userPhoneEditText: EditText = view.findViewById(R.id.userPhoneEditText)
        val addButton: Button = view.findViewById(R.id.addButton)

        addButton.setOnClickListener {
            val userId = userIdEditText.text.toString()
            val userName = userNameEditText.text.toString()
            val userPhone = userPhoneEditText.text.toString()

            if (userId.isNotBlank() && userName.isNotBlank() && userPhone.isNotBlank()) {
                val user = User(userId, userName, userPhone)
                addUserListener?.onUserAdded(user)
                parentFragmentManager.popBackStack()
                Toast.makeText(requireContext(), "User added Successfully", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(requireContext(), "Enter all the details", Toast.LENGTH_SHORT).show()
            }

        }

        return view


    }
}
