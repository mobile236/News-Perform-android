package com.news.perform

import com.news.perform.data.network.WeatherService
import com.news.perform.data.network.WeatherClient
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class WeatherApiTest {

    private lateinit var weatherService: WeatherService

    @Before
    fun setup(){
        weatherService = WeatherClient.createClient().create(WeatherService::class.java)
    }

    @Test
    fun testNetworkCall(){
        runBlocking {
            val weatherData = weatherService.getWeatherData()
            assertNotNull(weatherData)
            assertTrue(weatherData.isSuccessful)
        }
    }

    @Test
    fun testNonNullData(){
        runBlocking {
            val weatherData = weatherService.getWeatherData()
            val weatherDataBody = weatherData.body()
            assertNotNull(weatherData)
            assertTrue(weatherDataBody?.weatherDataList?.isNotEmpty() ?: false)
        }
    }

}