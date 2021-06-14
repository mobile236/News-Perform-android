package com.news.perform.model

import com.squareup.moshi.Json

data class Sport(
    @Json(name = "_description")
    val description: String,
    @Json(name = "_sportID")
    val sportID: Long
)