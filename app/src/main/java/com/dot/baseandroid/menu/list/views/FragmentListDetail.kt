package com.dot.baseandroid.menu.list.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.FragmentListDetailBinding
import com.dot.baseandroid.main.MainActivity
import com.dot.baseandroid.menu.list.models.PlaceModel
import com.dot.baseandroid.menu.list.viewmodels.CustomListDetailViewModelFactory
import com.dot.baseandroid.menu.list.viewmodels.FragmentListDetailViewModel

class FragmentListDetail: Fragment() {

    private lateinit var binding: FragmentListDetailBinding
    private lateinit var viewModel: FragmentListDetailViewModel

    private val args: FragmentListDetailArgs by navArgs()
    private var placeModel: PlaceModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        placeModel = args.dataDetailListPlace
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).hideNavigation(true)
        viewModel = ViewModelProvider(this, CustomListDetailViewModelFactory(placeModel!!, requireActivity().application)).get(FragmentListDetailViewModel::class.java)
        binding.listDetail = viewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as MainActivity).hideNavigation(false)
    }

}