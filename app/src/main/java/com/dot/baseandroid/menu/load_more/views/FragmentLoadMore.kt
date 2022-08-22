package com.dot.baseandroid.menu.load_more.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.FragmentLoadMoreBinding
import com.dot.baseandroid.menu.list.models.PostModel
import com.dot.baseandroid.menu.load_more.adapters.LoadMoreAdapter
import com.dot.baseandroid.menu.load_more.adapters.PostPagingAdapter
import com.dot.baseandroid.menu.load_more.viewmodels.LoadMoreViewModel
import kotlinx.coroutines.launch

class FragmentLoadMore: Fragment() {

    private lateinit var binding: FragmentLoadMoreBinding
    private val viewModel: LoadMoreViewModel by viewModels()

    private lateinit var postPagingAdapter: PostPagingAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_load_more, container, false)
        binding.lifecycleOwner = this
        binding.notification = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSwipeRefresh()
        setupRecyclerView()
        observeLiveData()
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefreshListNotification.setOnRefreshListener {
            binding.swipeRefreshListNotification.isRefreshing = false
            postPagingAdapter.refresh()
        }
    }

    private fun setupRecyclerView() {
        postPagingAdapter = PostPagingAdapter{
            onItemClicked(it)
        }
        binding.recyclerViewListNotification.adapter = postPagingAdapter.withLoadStateFooter(
            footer = LoadMoreAdapter()
        )
    }

    private fun observeLiveData() {
        lifecycleScope.launch {
            viewModel.loadPaginationData().collect {
                postPagingAdapter.submitData(it)
            }
        }
    }

    private fun onItemClicked(postModel: PostModel) {
        val action = FragmentLoadMoreDirections.actionToPostPagingDetail(postModel)
        view?.findNavController()?.navigate(action)
    }

}