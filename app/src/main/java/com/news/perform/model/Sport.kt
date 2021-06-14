package com.news.perform.model

import com.google.gson.annotations.SerializedName

data class Sport(
    @SerializedName( "_description")
    val description: String,
    @SerializedName( "_sportID")
    val sportID: Long
)