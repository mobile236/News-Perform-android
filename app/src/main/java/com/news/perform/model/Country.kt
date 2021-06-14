package com.news.perform.model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("_countryID")
    val countryID: Long,
    @SerializedName("_name")
    val name: String
)