package com.example.cleanarch3.presentation

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarch3.databinding.FragmentPostListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class PostList : Fragment() {

    private var _binding: FragmentPostListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PostViewModel by viewModels()

    // Create the adapter
    private val postAdapter = PostAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup RecyclerView
        binding.recyclerViewPosts.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = postAdapter
        }

        // Collect the latest posts and update the adapter
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.postsState.collectLatest { posts ->
                postAdapter.setData(posts)
            }
        }

        // Load posts
        viewModel.loadPosts()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
