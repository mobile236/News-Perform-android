package com.news.perform.data

import com.news.perform.data.local.dao.CountryDao

class CountryRepository(private val countryDao: CountryDao) {

    fun getCountryName() = countryDao.getCountryNames()
}