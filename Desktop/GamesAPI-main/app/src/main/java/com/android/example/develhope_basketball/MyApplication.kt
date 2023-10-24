package com.android.example.develhope_basketball

import android.app.Application
import android.content.SharedPreferences
import com.android.example.develhope_basketball.network.ApiProvider

class MyApplication : Application() {

    private val provider = ApiProvider()

    private lateinit  var preferences : SharedPreferences

    lateinit var factory : MainViewModelFactory

    override fun onCreate() {
        super.onCreate()

        preferences = getSharedPreferences("myPref", MODE_PRIVATE)

        factory = MainViewModelFactory(provider, preferences)
    }


}