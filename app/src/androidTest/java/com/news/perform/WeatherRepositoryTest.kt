package com.news.perform

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.news.perform.data.WeatherRepository
import com.news.perform.data.local.dao.AppDatabase
import com.news.perform.data.local.dao.WeatherDao
import com.news.perform.data.network.WeatherClient
import com.news.perform.data.network.WeatherService
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WeatherRepositoryTest {

    private lateinit var weatherService: WeatherService
    private lateinit var weatherDao: WeatherDao

    @Before
    fun setup(){
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        weatherService = WeatherClient.createClient().create(WeatherService::class.java)
        weatherDao = AppDatabase.getInstance(appContext).weatherDao()
    }

    @Test
    fun testGetWeatherData() {
        val repository = WeatherRepository(weatherService, weatherDao)
        runBlocking {
            assertNotNull(repository.getWeatherData())
        }
    }
}