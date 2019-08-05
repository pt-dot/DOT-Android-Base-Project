package com.dot.baseandroid.menu.list.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.FragmentListBinding
import com.dot.baseandroid.menu.list.adapters.MyListAdapter
import com.dot.baseandroid.menu.list.viewmodels.FragmentListViewModel

class FragmentList: Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var viewModel: FragmentListViewModel

    private lateinit var adapter: MyListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FragmentListViewModel::class.java)
        binding.list = viewModel

        setupSwipeRefresh()
        setupRecyclerView()
        observeLiveData()

        viewModel.getList(context!!)
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefreshList.setOnRefreshListener {
            viewModel.getList(context!!)
        }
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerViewList.layoutManager = layoutManager

        adapter = MyListAdapter {

        }
        binding.recyclerViewList.adapter = adapter
    }

    private fun observeLiveData() {
        viewModel.isLoading.observe(this, Observer {
            binding.swipeRefreshList.isRefreshing = it
        })
        viewModel.liveDataList.observe(this, Observer {
            adapter.submitList(it)
        })
    }

}