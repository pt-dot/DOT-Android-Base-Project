package com.dot.baseandroid.menu.gallery.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.FragmentGalleryBinding
import com.dot.baseandroid.menu.gallery.adapters.GalleryAdapter
import com.dot.baseandroid.menu.gallery.viewmodels.FragmentGalleryViewModel

class FragmentGallery: Fragment() {

    private lateinit var binding: FragmentGalleryBinding
    private lateinit var viewModel: FragmentGalleryViewModel

    private lateinit var adapter: GalleryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_gallery, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FragmentGalleryViewModel::class.java)
        binding.gallery = viewModel

        setupSwipeRefresh()
        setupRecyclerView()
        observeData()

        viewModel.getListGallery(context!!)
    }

    private fun observeData() {
        viewModel.isLoading.observe(this, Observer {
            binding.swipeRefreshListGallery.isRefreshing = it
        })
        viewModel.liveDataListGallery.observe(this, Observer {
            adapter.submitList(it)
        })
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefreshListGallery.setOnRefreshListener {
            viewModel.getListGallery(context!!)
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerViewListGallery.layoutManager = GridLayoutManager(context, 3)
        adapter = GalleryAdapter {

        }
        binding.recyclerViewListGallery.adapter = adapter
    }

}