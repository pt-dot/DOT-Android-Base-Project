package com.dot.baseandroid.menu.gallery.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.FragmentGalleryDetailBinding
import com.dot.baseandroid.main.MainActivity
import com.dot.baseandroid.menu.gallery.viewmodels.GalleryDetailViewModel
import com.dot.baseandroid.utils.ViewModelFragmentFactory

class FragmentGalleryDetail: Fragment() {

    private val args: FragmentGalleryDetailArgs by navArgs()
    private lateinit var binding: FragmentGalleryDetailBinding
    private val viewModel: GalleryDetailViewModel by viewModels { ViewModelFragmentFactory(args.dataDetailGallery as Any) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_gallery_detail, container, false)
        binding.galleryDetail = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).hideNavigation(true)
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as MainActivity).hideNavigation(false)
    }

}