package com.example.user_recyclerview.view.showuserpost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.user_recyclerview.R
import com.example.user_recyclerview.viewmodel.ShowPostViewModel
import dagger.hilt.android.AndroidEntryPoint

class ShowPostFragment : Fragment() {
    private lateinit var postAdapter: PostAdapter
    private  lateinit var showPostViewModel : ShowPostViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_post, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView : RecyclerView = view.findViewById(R.id.postRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        showPostViewModel = ViewModelProvider(this).get(ShowPostViewModel::class.java)
        postAdapter = PostAdapter(requireContext()) { postId ->
            showPostViewModel.toggleFav(postId)   // perform like operation
        }
        recyclerView.adapter = postAdapter
        showPostViewModel.fetchPosts()
        showPostViewModel.observePost().observe(viewLifecycleOwner) { post ->
           postAdapter.setPostData(post)
        }
    }
}