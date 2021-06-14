package com.news.perform.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.*


internal fun <T: ViewModel> Fragment.getViewModel(modelClass: Class<T>, viewModelFactory: ViewModelProvider.Factory? = null): T {
    return viewModelFactory?.let { ViewModelProvider(this, it).get(modelClass) } ?:
    ViewModelProvider(this).get(modelClass)
}
