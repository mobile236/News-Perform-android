package com.news.perform.data.local.dao

import androidx.room.Dao
import com.news.perform.model.Country

@Dao
abstract class CountryDao: BaseDao<Country> {
}