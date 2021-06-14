package com.news.perform.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.news.perform.model.WeatherDataList
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertData(weatherDataList: WeatherDataList)


    @Query("SELECT * FROM weather")
    abstract fun getWeather(): Flow<List<WeatherDataList>>

}