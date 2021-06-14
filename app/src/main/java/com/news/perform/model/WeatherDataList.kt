package com.news.perform.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "weather")
data class WeatherDataList(
    @Embedded
    @SerializedName("_country")
    var country: Country,
    @SerializedName( "_name")
    var locationName: String,
    @SerializedName( "_sport")
    @Embedded
    var sport: Sport,
    @SerializedName( "_venueID")
    @PrimaryKey(autoGenerate = false)
    var venueId: Long,
    @SerializedName( "_weatherCondition")
    var weatherCondition: String,
    @SerializedName("_weatherConditionIcon")
    var weatherConditionIcon: String,
    @SerializedName("_weatherFeelsLike")
    var weatherFeelsLike: String,
    @SerializedName( "_weatherHumidity")
    var weatherHumidity: String,
    @SerializedName("_weatherLastUpdated")
    var weatherLastUpdated: Int,
    @SerializedName("_weatherTemp")
    var weatherTemp: String,
    @SerializedName("_weatherWind")
    var weatherWind: String
){
    constructor(): this(
        Country(0,0,0, ""), "",
        Sport(0,0,"", 0), 0,
        "", "", "", "", 0,
        "", "")
}