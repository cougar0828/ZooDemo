package com.cougar.zoodemo.api

import android.util.Log
import com.cougar.zoodemo.model.category.CategoriesData
import com.cougar.zoodemo.model.category.CategoryResult
import com.cougar.zoodemo.model.plant.PlantsData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object Repository {

    const val TAG = "@Repository"
    const val BASE_URL = "https://data.taipei/opendata/datalist/"
    const val CATE_URL =
        "apiAccess?scope=resourceAquire&rid=5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a"
    const val PLANT_URL =
        "apiAccess?scope=resourceAquire&rid=f18de02f-b6c9-47c0-8cda-50efad621c14"

    interface RepoService {
        @GET(CATE_URL)
        fun initCategoryList(): Call<CategoriesData>

        @GET(PLANT_URL)
        fun initPlantList(): Call<PlantsData>
    }

    fun getCategoryList(listener: RequestListener) {

        var retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        var service = retrofit.create(RepoService::class.java)
        var call = service.initCategoryList()

        call.enqueue(object : Callback<CategoriesData> {
            override fun onFailure(call: Call<CategoriesData>, t: Throwable) {
                Log.e(TAG, "低能動物園")
                listener.reqFailure("listener也認為是低能動物園")
            }

            override fun onResponse(
                call: Call<CategoriesData>,
                response: Response<CategoriesData>
            ) {
                if (response.code() == 200) {
                    var data = response.body() as CategoriesData
                    Log.e(TAG, "乖乖的動物園 : ${data.result.results[0].E_Name}")
                    listener.reqSuccess(data.result)
                }
            }
        })
    }

    fun getPlantList(listener: RequestListenerPlant) {

        var retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        var service = retrofit.create(RepoService::class.java)
        var call = service.initPlantList()

        call.enqueue(object : Callback<PlantsData> {
            override fun onFailure(call: Call<PlantsData>, t: Throwable) {
                Log.e(TAG, "白痴植物園")
                listener.reqFailure("這就是白痴植物園")
            }

            override fun onResponse(
                call: Call<PlantsData>,
                response: Response<PlantsData>
            ) {
                if (response.code() == 200) {
                    var data = response.body() as PlantsData
                    Log.e(TAG, "好棒棒植物園 : ${data.result.results[0].F_Name_Ch}")
                    listener.reqSuccess(data)
                }
            }
        })
    }
}