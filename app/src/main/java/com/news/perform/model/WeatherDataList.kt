package com.news.perform.model

import com.squareup.moshi.Json

data class WeatherDataList(
    @Json(name = "_country")
    val country: Country,
    @Json(name = "_name")
    val name: String,
    @Json(name = "_sport")
    val sport: Sport,
    @Json(name = "_venueID")
    val venueID: String,
    @Json(name = "_weatherCondition")
    val weatherCondition: String,
    @Json(name = "_weatherConditionIcon")
    val weatherConditionIcon: String,
    @Json(name = "_weatherFeelsLike")
    val weatherFeelsLike: String,
    @Json(name = "_weatherHumidity")
    val weatherHumidity: String,
    @Json(name = "_weatherLastUpdated")
    val weatherLastUpdated: Int,
    @Json(name = "_weatherTemp")
    val weatherTemp: String,
    @Json(name = "_weatherWind")
    val weatherWind: String
)