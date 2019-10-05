package com.cougar.zoodemo.api

import com.cougar.zoodemo.model.plant.PlantResult
import com.cougar.zoodemo.model.plant.PlantsData

interface RequestListenerPlant{

    fun reqSuccess(data : PlantsData)

    fun reqFailure(msg : String)
}