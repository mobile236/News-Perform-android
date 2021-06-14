package com.news.perform.model

data class WeatherModel(
    val `data`: List<Data>?,
    val isOkay: Boolean?,
    val ret: Boolean?
)