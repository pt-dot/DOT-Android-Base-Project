package com.dot.baseandroid.menu.load_more.adapters

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.dot.baseandroid.menu.load_more.adapters.viewholders.LoadMoreViewHolder

class LoadMoreAdapter: LoadStateAdapter<LoadMoreViewHolder>() {

    override fun onBindViewHolder(holder: LoadMoreViewHolder, loadState: LoadState) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadMoreViewHolder {
        return LoadMoreViewHolder.from(parent)
    }
}