package com.news.perform.ui.country

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.news.perform.ui.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CountryViewModel(application: Application): BaseViewModel(application) {

    fun getCountryNames(): LiveData<List<String>>{
        val countryData = MutableLiveData<List<String>>()
        viewModelScope.launch(Dispatchers.IO){
            countryRepository.getCountryName().collectLatest {  countryList ->
                countryData.postValue(countryList)
            }
        }
        return countryData
    }
}