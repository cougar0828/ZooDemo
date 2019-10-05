package com.cougar.zoodemo.model.plant

data class PlantResult(
    val limit: Int,
    val offset: Int,
    val count: Int,
    val sort: String,
    val results: ArrayList<PlantResultContent> = arrayListOf()
)