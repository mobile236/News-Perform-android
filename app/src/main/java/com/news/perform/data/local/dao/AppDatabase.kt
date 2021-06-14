package com.news.perform.data.local.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.news.perform.Constants
import com.news.perform.model.Country
import com.news.perform.model.Sport
import com.news.perform.model.WeatherDataList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor

@Database(entities = [WeatherDataList::class, Sport::class, Country::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun weatherDao(): WeatherDao
    abstract fun sportDao(): SportDao
    abstract fun countryDao(): CountryDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this){
                INSTANCE ?: Room.databaseBuilder(context,
                    AppDatabase::class.java, Constants.DB_NAME)
                    .setQueryExecutor(Dispatchers.IO.asExecutor())
                    .fallbackToDestructiveMigration()
                    .build().also { INSTANCE = it }
            }
        }

        fun clearDb(context: Context) = getInstance(context).clearAllTables()
    }
}