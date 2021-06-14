package com.news.perform.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "weather")
data class WeatherDataList(
    // Tell Room to ignore this field for now
    @Ignore
    @SerializedName("_country")
    var country: Country,
    @SerializedName( "_name")
    var name: String,
    @SerializedName( "_sport")
    // Tell Room to ignore this field for now
    @Ignore
    var sport: Sport,
    @SerializedName( "_venueID")
    @PrimaryKey(autoGenerate = false)
    var venueID: Long,
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
        Country(0, ""), "", Sport("", 0), 0,
        "", "", "", "", 0,
        "", "")
}