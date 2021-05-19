package com.dot.baseandroid.menu.list.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.FragmentListDetailBinding
import com.dot.baseandroid.main.MainActivity
import com.dot.baseandroid.menu.list.viewmodels.ListDetailViewModel
import com.dot.baseandroid.utils.ViewModelFragmentFactory

class FragmentListDetail: Fragment() {

    private val args: FragmentListDetailArgs by navArgs()
    private lateinit var binding: FragmentListDetailBinding
    private val viewModel: ListDetailViewModel by viewModels { ViewModelFragmentFactory(args.dataDetailListPlace as Any) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_detail, container, false)
        binding.listDetail = viewModel
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