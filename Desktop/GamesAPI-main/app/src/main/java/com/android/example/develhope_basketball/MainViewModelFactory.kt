package com.android.example.develhope_basketball

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.example.develhope_basketball.network.ApiProvider
import com.android.example.develhope_basketball.ui.MainViewModel

class MainViewModelFactory(private val provider: ApiProvider, private val preferences: SharedPreferences) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(provider, preferences) as T
        } else {
            throw IllegalArgumentException("Error")
        }
    }
}