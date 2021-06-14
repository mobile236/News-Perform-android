package com.news.perform.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.news.perform.model.WeatherDataList
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WeatherDao: BaseDao<WeatherDataList> {

    @Query("SELECT * FROM weather INNER JOIN sport ON weather.venueId = sport.sportVenueId INNER JOIN country ON country.countryVenueId = weather.venueId ORDER BY weather.locationName ASC LIMIT :size")
    abstract fun getWeather(size: Int): Flow<List<WeatherDataList>>

    @Query("SELECT * FROM weather INNER JOIN sport ON weather.venueId = sport.sportVenueId INNER JOIN country ON country.countryVenueId = weather.venueId ORDER BY weather.weatherTemp ASC LIMIT :size")
    abstract fun getWeatherByTemperature(size: Int): Flow<List<WeatherDataList>>

    @Query("SELECT * FROM weather INNER JOIN sport ON weather.venueId = sport.sportVenueId INNER JOIN country ON country.countryVenueId = weather.venueId ORDER BY weather.weatherLastUpdated ASC LIMIT :size")
    abstract fun getWeatherByLastUpdated(size: Int): Flow<List<WeatherDataList>>


    @Query("SELECT * FROM weather WHERE venueId =:venueId")
    abstract fun getWeatherByVenueId(venueId: Long): Flow<WeatherDataList>
}