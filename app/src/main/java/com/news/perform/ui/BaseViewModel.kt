package com.news.perform.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.news.perform.data.CountryRepository
import com.news.perform.data.WeatherRepository
import com.news.perform.data.local.dao.AppDatabase
import com.news.perform.data.network.WeatherClient
import com.news.perform.data.network.WeatherService

abstract class BaseViewModel(application: Application): AndroidViewModel(application) {

    private val weatherService = WeatherClient.createClient().create(WeatherService::class.java)
    private val appDatabase = AppDatabase.getInstance(application)
    val isLoading = MutableLiveData<Boolean>()
    protected val countryRepository = CountryRepository(appDatabase.countryDao())
    protected val weatherRepository = WeatherRepository(weatherService, appDatabase.weatherDao(),
        appDatabase.sportDao(), appDatabase.countryDao())

    override fun onCleared() {
        super.onCleared()
        WeatherClient.destroy()
    }
}