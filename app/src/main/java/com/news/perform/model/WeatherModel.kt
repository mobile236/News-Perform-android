package com.news.perform.model

import androidx.room.Embedded
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class WeatherModel(
    @Embedded
    @SerializedName("data")
    val weatherDataList: List<WeatherDataList>,
    val isOkay: Boolean,
    val ret: Boolean
)