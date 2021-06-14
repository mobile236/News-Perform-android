package com.news.perform.model

import androidx.room.Embedded
import androidx.room.Entity
import com.squareup.moshi.Json

@Entity
data class WeatherModel(
    @Json(name = "data")
    @Embedded
    val weatherDataList: List<WeatherDataList>,
    val isOkay: Boolean,
    val ret: Boolean
)