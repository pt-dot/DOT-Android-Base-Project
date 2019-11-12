package com.dot.baseandroid.menu.gallery.views

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.FragmentGalleryBinding
import com.dot.baseandroid.menu.gallery.adapters.GalleryAdapter
import com.dot.baseandroid.menu.gallery.models.GalleryModel
import com.dot.baseandroid.menu.gallery.viewmodels.FragmentGalleryViewModel

class FragmentGallery: Fragment() {

    private lateinit var binding: FragmentGalleryBinding
    private lateinit var viewModel: FragmentGalleryViewModel

    private lateinit var adapter: GalleryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_gallery, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragmentGalleryViewModel::class.java)
        binding.gallery = viewModel

        setupSwipeRefresh()
        setupRecyclerView()
        observeData()

        viewModel.getListGallery(context!!)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        activity?.recreate()
    }

    private fun observeData() {
        viewModel.liveDataListGallery.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefreshListGallery.setOnRefreshListener {
            viewModel.getListGallery(context!!)
        }
    }

    private fun setupRecyclerView() {
        val spanCount = context?.resources?.getInteger(R.integer.gallery_span_count)
        binding.recyclerViewListGallery.layoutManager = GridLayoutManager(context, spanCount!!)
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