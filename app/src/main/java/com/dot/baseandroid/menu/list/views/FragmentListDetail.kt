package com.dot.baseandroid.menu.list.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.FragmentListDetailBinding
import com.dot.baseandroid.menu.list.viewmodels.FragmentListDetailViewModel

class FragmentListDetail: Fragment() {

    private lateinit var binding: FragmentListDetailBinding
    private lateinit var viewModel: FragmentListDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FragmentListDetailViewModel::class.java)
        binding.listDetail = viewModel
    }

}