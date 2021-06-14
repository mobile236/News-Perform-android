package com.news.perform.data.network

import com.google.gson.GsonBuilder
import com.news.perform.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherClient {
    companion object {

        @Volatile
        private var INSTANCE: Retrofit? = null

        fun createClient(): Retrofit {
            return INSTANCE ?: Retrofit.Builder()
                .baseUrl(Constants.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder()
                    .enableComplexMapKeySerialization()
                    .serializeNulls()
                    .setPrettyPrinting()
                    .setLenient()
                    .setVersion(1.0)
                    .create()))
                .build().also { INSTANCE = it }
        }

        fun destroy() {
            INSTANCE = null
        }

    }
}