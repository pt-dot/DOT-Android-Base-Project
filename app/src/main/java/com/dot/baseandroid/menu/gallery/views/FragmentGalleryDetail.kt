package com.dot.baseandroid.menu.gallery.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.FragmentGalleryDetailBinding
import com.dot.baseandroid.main.MainActivity
import com.dot.baseandroid.menu.gallery.models.GalleryModel
import com.dot.baseandroid.menu.gallery.viewmodels.CustomGalleryDetailViewModelFactory
import com.dot.baseandroid.menu.gallery.viewmodels.FragmentGalleryDetailViewModel

class FragmentGalleryDetail: Fragment() {

    private lateinit var binding: FragmentGalleryDetailBinding
    private lateinit var viewModel: FragmentGalleryDetailViewModel

    private val args: FragmentGalleryDetailArgs by navArgs()
    private var galleryModel: GalleryModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        galleryModel = args.dataDetailGallery
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_gallery_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).hideNavigation(true)
        viewModel = ViewModelProviders.of(this, CustomGalleryDetailViewModelFactory(galleryModel!!, activity!!.application)).get(FragmentGalleryDetailViewModel::class.java)
        binding.galleryDetail = viewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as MainActivity).hideNavigation(false)
    }

}