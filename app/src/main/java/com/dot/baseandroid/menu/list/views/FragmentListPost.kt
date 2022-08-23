package com.dot.baseandroid.menu.list.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.FragmentListPostBinding
import com.dot.baseandroid.menu.list.adapters.ListPostAdapter
import com.dot.baseandroid.menu.list.models.PostModel
import com.dot.baseandroid.menu.list.viewmodels.ListPostViewModel

class FragmentListPost: Fragment() {

    private lateinit var binding: FragmentListPostBinding
    private val viewModel: ListPostViewModel by viewModels()

    private lateinit var adapter: ListPostAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_post, container, false)
        binding.lifecycleOwner = this
        binding.list = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSwipeRefresh()
        setupRecyclerView()
        observeLiveData()

        viewModel.getPosts()
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefreshList.setOnRefreshListener {
            viewModel.getPosts()
        }
    }

    private fun setupRecyclerView() {
        adapter = ListPostAdapter {
            onItemClick(it)
        }
        binding.recyclerViewList.adapter = adapter
    }

    private fun observeLiveData() {
        viewModel.liveDataList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun onItemClick(placeModel: PostModel) {
        val action = FragmentListPostDirections.actionToOneDetail()
        action.dataDetailListPost = placeModel
        findNavController().navigate(action)
    }

}