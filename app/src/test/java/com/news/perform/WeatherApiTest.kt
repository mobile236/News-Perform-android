package com.news.perform

import com.news.perform.data.network.WeatherApi
import com.news.perform.data.network.WeatherClient
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class WeatherApiTest {

    private lateinit var weatherApi: WeatherApi

    @Before
    fun setup(){
        weatherApi = WeatherClient.createClient().create(WeatherApi::class.java)

    }

    @Test
    fun testNetworkCall(){
        runBlocking {
            val weatherData = weatherApi.getWeatherData()
            assertNotNull(weatherData)
            assertTrue(weatherData.isSuccessful)
        }
    }

    @Test
    fun testNonNullData(){
        runBlocking {
            val weatherData = weatherApi.getWeatherData()
            val weatherDataBody = weatherData.body()
            assertNotNull(weatherData)
            assertTrue(weatherDataBody?.data?.isNotEmpty() ?: false)
        }
    }

}