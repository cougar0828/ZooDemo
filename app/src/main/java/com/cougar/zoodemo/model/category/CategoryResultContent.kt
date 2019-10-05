package com.cougar.zoodemo.model.category

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryResultContent(
    val _id: Int,
    val E_Pic_URL: String,
    val E_Geo: String,
    val E_Info: String,
    val E_no: String,
    val E_Category: String,
    val E_Name: String,
    val E_Memo: String,
    val E_URL: String
) : Parcelable
