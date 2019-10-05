package com.cougar.zoodemo.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cougar.zoodemo.adapter.mixpage.PlantListAdapter
import com.cougar.zoodemo.model.category.CategoryResultContent

class MixPageFactory : ViewModelProvider.Factory {

    var mApplication = Application()
    var mAdapter: PlantListAdapter
    var mCategory = CategoryResultContent(0, "", "", "", "", "", "", "", "")

    constructor(
        application: Application,
        adapter: PlantListAdapter,
        category: CategoryResultContent
    ) {
        mApplication = application
        mAdapter = adapter
        mCategory = category
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MixPageViewModel(mAdapter, mCategory) as T
    }
}