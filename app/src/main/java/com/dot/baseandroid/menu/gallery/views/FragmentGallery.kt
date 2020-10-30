package com.dot.baseandroid.menu.gallery.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.FragmentGalleryBinding
import com.dot.baseandroid.menu.gallery.adapters.GalleryAdapter
import com.dot.baseandroid.menu.gallery.models.GalleryModel
import com.dot.baseandroid.menu.gallery.viewmodels.GalleryViewModel

class FragmentGallery: Fragment() {

    private lateinit var binding: FragmentGalleryBinding
    private val viewModel: GalleryViewModel by viewModels()

    private lateinit var adapter: GalleryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_gallery, container, false)
        binding.lifecycleOwner = this
        binding.gallery = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSwipeRefresh()
        setupRecyclerView()
        observeData()

        viewModel.getListGallery()
    }

    private fun observeData() {
        viewModel.liveDataListGallery.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefreshListGallery.setOnRefreshListener {
            viewModel.getListGallery()
        }
    }

    private fun setupRecyclerView() {
        adapter = GalleryAdapter {
            onItemClick(it)
        }
        binding.recyclerViewListGallery.adapter = adapter
    }

    private fun onItemClick(galleryModel: GalleryModel) {
        val action = FragmentGalleryDirections.actionToTwoDetail()
        action.dataDetailGallery = galleryModel
        findNavController().navigate(action)
    }

}