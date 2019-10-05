package com.cougar.zoodemo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.cougar.zoodemo.R
import com.cougar.zoodemo.adapter.categorylist.CategoryListAdapter
import com.cougar.zoodemo.api.Repository
import com.cougar.zoodemo.api.RequestListener
import com.cougar.zoodemo.model.category.CategoryResult
import com.cougar.zoodemo.model.category.CategoryResultContent
import com.cougar.zoodemo.ui.categorylist.CategoryListFragment
import com.cougar.zoodemo.ui.categorylist.CategoryListFragmentDirections

class CategoryListViewModel(var mAdapter: CategoryListAdapter, val frag : CategoryListFragment) :
    ViewModel(), RequestListener {

    val TAG = "@CategoryListViewModel"

    init {
        getCategoryList()
    }

    private fun getCategoryList() {
        Log.e(TAG, "下一站 : 動物園")
        Repository.getCategoryList(this)
    }

    override fun reqSuccess(data: CategoryResult) {
        Log.e(TAG, "動物園 到了")
        mAdapter.mDataList = data.results
        mAdapter.notifyDataSetChanged()
    }

    override fun reqFailure(msg: String) {
        Log.e(TAG, "動物園 eat shit!! ")
    }

    override fun itemClick(catetory: CategoryResultContent) {
        Log.e(TAG, "我要去這個館 : ${catetory.E_Name}")
        var action = CategoryListFragmentDirections.actionNavCategorylisyToNavMixpage(catetory)
        frag.findNavController().navigate(action)
    }
}