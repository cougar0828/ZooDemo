package com.cougar.zoodemo.api

import com.cougar.zoodemo.model.category.CategoryResult
import com.cougar.zoodemo.model.category.CategoryResultContent

interface RequestListener{

    fun reqSuccess(data : CategoryResult)

    fun reqFailure(msg : String)

    fun itemClick(content : CategoryResultContent)
}