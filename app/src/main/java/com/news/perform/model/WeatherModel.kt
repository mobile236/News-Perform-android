package com.news.perform.model

import com.squareup.moshi.Json

data class WeatherModel(
    @Json(name = "data")
    val weatherDataList: List<Data>,
    val isOkay: Boolean,
    val ret: Boolean
)