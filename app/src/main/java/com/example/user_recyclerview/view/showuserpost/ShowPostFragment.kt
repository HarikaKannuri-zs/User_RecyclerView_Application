package com.example.user_recyclerview.view.showuserpost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.user_recyclerview.R
import com.example.user_recyclerview.viewmodel.ShowPostViewModel

class ShowPostFragment : Fragment() {
    private val postAdapter: PostAdapter by lazy { PostAdapter() }
    private lateinit var showPostViewModel : ShowPostViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_post, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showPostViewModel = ViewModelProvider(this@ShowPostFragment).get(ShowPostViewModel::class.java)
        val recyclerView : RecyclerView = view.findViewById(R.id.postRecyclerView)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = postAdapter
        }
        fetchPosts()
    }
    private fun fetchPosts(){
        showPostViewModel.postAPICall{ posts ->
            if(posts.isNotEmpty()){
                postAdapter.setPostData(posts)
            }else{
                Toast.makeText(requireContext(),"Failure",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
