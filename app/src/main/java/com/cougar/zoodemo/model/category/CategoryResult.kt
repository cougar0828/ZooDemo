package com.cougar.zoodemo.model.category

data class CategoryResult(
    val limit: Int,
    val offset: Int,
    val count: Int,
    val sort: String,
    val results: ArrayList<CategoryResultContent> = arrayListOf()
)