package com.news.perform.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "weather")
data class WeatherDataList(
    // Tell Room to ignore this field for now
    @Ignore
    @Json(name = "_country")
    var country: Country,
    @Json(name = "_name")
    var name: String,
    @Json(name = "_sport")
    // Tell Room to ignore this field for now
    @Ignore
    var sport: Sport,
    @Json(name = "_venueID")
    @PrimaryKey(autoGenerate = false)
    var venueID: Long,
    @Json(name = "_weatherCondition")
    var weatherCondition: String,
    @Json(name = "_weatherConditionIcon")
    var weatherConditionIcon: String,
    @Json(name = "_weatherFeelsLike")
    var weatherFeelsLike: String,
    @Json(name = "_weatherHumidity")
    var weatherHumidity: String,
    @Json(name = "_weatherLastUpdated")
    var weatherLastUpdated: Int,
    @Json(name = "_weatherTemp")
    var weatherTemp: String,
    @Json(name = "_weatherWind")
    var weatherWind: String
){
    constructor(): this(
        Country(0, ""), "", Sport("", 0), 0,
        "", "", "", "", 0,
        "", "")
}