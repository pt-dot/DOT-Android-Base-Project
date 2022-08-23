package com.dot.baseandroid.menu.load_more.views

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.navArgs
import com.dot.baseandroid.R
import com.dot.baseandroid.databinding.ActivityPostPagingDetailBinding
import com.dot.baseandroid.menu.load_more.viewmodels.DetailPostPagingViewModel
import com.dot.baseandroid.utils.ViewModelActivityFactory

class DetailPostPagingActivity: AppCompatActivity(){

    private val args: DetailPostPagingActivityArgs by navArgs()
    private lateinit var binding: ActivityPostPagingDetailBinding
    private val viewModel: DetailPostPagingViewModel by viewModels { ViewModelActivityFactory(application, args.dataDetailPostPaging) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_paging_detail)
        binding.lifecycleOwner = this
        binding.notification = viewModel

        setupToolbar()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.tbNotificationDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.detail)
    }

}