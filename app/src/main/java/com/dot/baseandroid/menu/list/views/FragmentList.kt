package com.dot.baseandroid.menu.list.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.FragmentListBinding
import com.dot.baseandroid.menu.list.viewmodels.FragmentListViewModel

class FragmentList: Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var viewModel: FragmentListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = FragmentListViewModel(activity?.application!!)
        binding.list = viewModel
    }

}