package com.news.perform.model

import com.squareup.moshi.Json

data class Country(
    @Json(name = "_countryID")
    val countryID: Long,
    @Json(name = "_name")
    val name: String
)