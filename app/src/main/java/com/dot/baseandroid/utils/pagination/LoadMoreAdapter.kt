package com.dot.baseandroid.utils.pagination

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

class LoadMoreAdapter: LoadStateAdapter<LoadMoreViewHolder>() {

    override fun onBindViewHolder(holder: LoadMoreViewHolder, loadState: LoadState) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadMoreViewHolder {
        return LoadMoreViewHolder.from(parent)
    }
}