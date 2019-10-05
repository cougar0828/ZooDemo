package com.cougar.zoodemo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cougar.zoodemo.adapter.mixpage.PlantListAdapter
import com.cougar.zoodemo.api.Repository
import com.cougar.zoodemo.api.RequestListenerPlant
import com.cougar.zoodemo.model.category.CategoryResultContent
import com.cougar.zoodemo.model.plant.PlantsData

class MixPageViewModel(var mAdapter: PlantListAdapter, val catetory: CategoryResultContent) :
    ViewModel(), RequestListenerPlant {

    val TAG = "@MixPageViewModel"

    val info = MutableLiveData<String>().apply {
        value = catetory.E_Info
    }

    val pause = MutableLiveData<String>().apply {
        if (catetory.E_Memo.isNotEmpty()) {
            value = catetory.E_Memo
        } else {
            value = "無休館資訊"
        }
    }

    val zone = MutableLiveData<String>().apply {
        value = catetory.E_Category
    }

    val picUrl = MutableLiveData<String>().apply {
        value = catetory.E_Pic_URL
    }

    init {
        getPlantList()
    }

    private fun getPlantList() {
        Log.e(TAG, "下一站 : 植物園區")
        Repository.getPlantList(this)
    }

    override fun reqSuccess(data: PlantsData) {
        Log.e(TAG, "植物園 到了")
        mAdapter.mDataList = data.result.results
        mAdapter.notifyDataSetChanged()
    }

    override fun reqFailure(msg: String) {
        Log.e(
            TAG,
            "植物園 eat shit!! "
        )//To change body of created functions use File | Settings | File Templates.
    }
}