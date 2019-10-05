package com.cougar.zoodemo.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cougar.zoodemo.adapter.categorylist.CategoryListAdapter
import com.cougar.zoodemo.ui.categorylist.CategoryListFragment

class CategoryListFactory : ViewModelProvider.Factory {

    var mApplication = Application()
    var mAdapter: CategoryListAdapter
    var mFragment: CategoryListFragment

    constructor(
        application: Application,
        adapter: CategoryListAdapter,
        fragment: CategoryListFragment
    ) {
        mApplication = application
        mAdapter = adapter
        mFragment = fragment
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CategoryListViewModel(mAdapter, mFragment) as T
    }
}