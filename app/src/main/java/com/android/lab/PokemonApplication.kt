package com.android.lab

import android.app.Application
import com.android.lab.data.DataDependencyInjection

class PokemonApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        DataDependencyInjection.inject(this)
    }
}