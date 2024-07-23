package com.example.user_recyclerview.view.showuserpost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.user_recyclerview.R
import com.example.user_recyclerview.viewmodel.showpost.ShowPostViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.example.user_recyclerview.view.adapter.PostAdapter

@AndroidEntryPoint
class ShowPostFragment : Fragment() {
    private lateinit var postAdapter: PostAdapter
    private val showPostViewModel: ShowPostViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_post, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView : RecyclerView = view.findViewById(R.id.postRecyclerView)
        postAdapter = PostAdapter(requireContext()) { postId ->
            showPostViewModel.toggleFav(postId)   // perform like operation
        }
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = postAdapter
        }
        showPostViewModel.fetchPosts()
        showPostViewModel.observePost().observe(viewLifecycleOwner) { post ->
           postAdapter.setPostData(post)
        }
    }
}