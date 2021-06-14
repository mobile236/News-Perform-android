package com.news.perform.model

data class Data(
    val _country: Country?,
    val _name: String?,
    val _sport: Sport?,
    val _venueID: String?,
    val _weatherCondition: String?,
    val _weatherConditionIcon: String?,
    val _weatherFeelsLike: String?,
    val _weatherHumidity: String?,
    val _weatherLastUpdated: Int?,
    val _weatherTemp: String?,
    val _weatherWind: String?
)