//package com.example.user_recyclerview.view.showuserpost
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.ViewModelProvider
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.user_recyclerview.R
//import com.example.user_recyclerview.model.local.UserDatabase
//import com.example.user_recyclerview.model.remote.RetrofitImplementation
//import com.example.user_recyclerview.model.repository.PostRepository
//import com.example.user_recyclerview.view.adapter.PostAdapter
//import com.example.user_recyclerview.viewmodel.showpost.ShowPostViewModel
//import com.example.user_recyclerview.viewmodel.showpost.ShowPostViewModelFactory
//
//class ShowPostFragment : Fragment() {
//    private lateinit var postAdapter: PostAdapter
//    private lateinit var showPostViewModel : ShowPostViewModel
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_show_post, container, false)
//    }
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        showPostViewModel = ViewModelProvider(this@ShowPostFragment, ShowPostViewModelFactory(
//            PostRepository(RetrofitImplementation().retroObj(), UserDatabase.getDatabase(requireContext()).postDao())
//        )).get(ShowPostViewModel::class.java)
//        val recyclerView : RecyclerView = view.findViewById(R.id.postRecyclerView)
//        recyclerView.layoutManager = LinearLayoutManager(context)
//        postAdapter = PostAdapter(requireContext()) { postId ->
//            showPostViewModel.toggleFav(postId)   // perform like operation
//        }
//        recyclerView.adapter = postAdapter
//        showPostViewModel.posts.observe(viewLifecycleOwner) { post ->
//            postAdapter.setPostData(post)
//        }
//        showPostViewModel.getPostsFromDb()
//    }
//}
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
import com.example.user_recyclerview.model.local.UserDatabase
import com.example.user_recyclerview.model.remote.RetrofitImplementation
import com.example.user_recyclerview.model.repository.PostRepository
import com.example.user_recyclerview.view.adapter.PostAdapter
import com.example.user_recyclerview.viewmodel.showpost.ShowPostViewModel
import com.example.user_recyclerview.viewmodel.showpost.ShowPostViewModelFactory

class ShowPostFragment : Fragment() {
    private lateinit var postAdapter: PostAdapter
    private lateinit var showPostViewModel : ShowPostViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_post, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showPostViewModel = ViewModelProvider(this@ShowPostFragment, ShowPostViewModelFactory(
            PostRepository(RetrofitImplementation().retroObj(), UserDatabase.getDatabase(requireContext()).postDao())
        )).get(ShowPostViewModel::class.java)
        val recyclerView : RecyclerView = view.findViewById(R.id.postRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        postAdapter = PostAdapter(requireContext()) { postId ->
            showPostViewModel.toggleFav(postId)   // perform like operation
        }
        recyclerView.adapter = postAdapter
        showPostViewModel.fetchPost()
        showPostViewModel.posts.observe(viewLifecycleOwner) { post ->
            postAdapter.setPostData(post)
        }
    }
}