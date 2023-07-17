package com.android.lab.data

import android.content.Context
import androidx.room.Room
import com.android.lab.data.local.PokemonDatabase
import com.android.lab.data.local.PokemonPreferences
import com.android.lab.data.remote.PokeAPI
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    single {
        PokemonRepository(get(), get())
    }

    single {
        PokemonPreferences(
            androidApplication().getSharedPreferences(
                "USER_PREF", Context.MODE_PRIVATE
            )
        )
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(PokeAPI::class.java)
    }

    single {
        val pokemonDb = Room.databaseBuilder(
            get(),
            PokemonDatabase::class.java, "database-pokemon"
        ).build()

        pokemonDb.pokemonDao()
    }
}

