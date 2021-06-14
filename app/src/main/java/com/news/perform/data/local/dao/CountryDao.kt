package com.news.perform.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.news.perform.model.Country
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CountryDao: BaseDao<Country> {

    @Query("SELECT DISTINCT countryName FROM country ORDER BY countryName ASC")
    abstract fun getCountryNames(): Flow<List<String>>
}