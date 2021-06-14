package com.news.perform.data.network

import com.news.perform.Constants
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class WeatherClient {
    companion object {

        @Volatile
        private var INSTANCE: Retrofit? = null

        fun createClient(): Retrofit {
            return INSTANCE ?: Retrofit.Builder()
                .baseUrl(Constants.SERVER_URL)
                .addConverterFactory(
                    MoshiConverterFactory
                        .create()
                        .withNullSerialization()
                        .asLenient()
                )
                .build().also { INSTANCE = it }
        }

        fun destroy() {
            INSTANCE = null
        }

    }
}