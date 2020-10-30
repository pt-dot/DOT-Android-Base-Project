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
import com.dot.baseandroid.databinding.FragmentListBinding
import com.dot.baseandroid.menu.list.adapters.MyListAdapter
import com.dot.baseandroid.menu.list.models.PlaceModel
import com.dot.baseandroid.menu.list.viewmodels.ListViewModel

class FragmentList: Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel: ListViewModel by viewModels()

    private lateinit var adapter: MyListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        binding.lifecycleOwner = this
        binding.list = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSwipeRefresh()
        setupRecyclerView()
        observeLiveData()

        viewModel.getList()
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefreshList.setOnRefreshListener {
            viewModel.getList()
        }
    }

    private fun setupRecyclerView() {
        adapter = MyListAdapter {
            onItemClick(it)
        }
        binding.recyclerViewList.adapter = adapter
    }

    private fun observeLiveData() {
        viewModel.liveDataList.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

    private fun onItemClick(placeModel: PlaceModel) {
        val action = FragmentListDirections.actionToOneDetail()
        action.dataDetailListPlace = placeModel
        findNavController().navigate(action)
    }

}