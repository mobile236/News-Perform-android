package com.news.perform.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.news.perform.model.WeatherDataList
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WeatherDao: BaseDao<WeatherDataList> {

    @Query("SELECT * FROM weather INNER JOIN sport ON weather.venueId = sport.sportVenueId INNER JOIN country ON country.countryVenueId = weather.venueId ORDER BY weather.locationName ASC")
    abstract fun getWeather(): Flow<List<WeatherDataList>>

}