package com.android.lab.data

import android.content.Context
import androidx.room.Room
import com.android.lab.data.local.PokemonDao
import com.android.lab.data.local.PokemonDatabase
import com.android.lab.data.local.PokemonPreferences
import com.android.lab.data.remote.PokeAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataDependencyInjection {

    lateinit var pokemonRepository: PokemonRepository
    private set

    lateinit var pokemonPreferences: PokemonPreferences
    private set

    fun inject(appContext: Context) {
        NetworkManager.start(appContext)
        pokemonRepository = PokemonRepository(
            createPokeAPI(),
            createPokemonDao(appContext)
        )
        pokemonPreferences = PokemonPreferences(
            appContext.getSharedPreferences("USER_PREF", Context.MODE_PRIVATE)
        )
    }

    private fun createPokeAPI(): PokeAPI {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(PokeAPI::class.java)
    }

    private fun createPokemonDao(appContext: Context): PokemonDao {
        val pokemonDb = Room.databaseBuilder(
            appContext,
            PokemonDatabase::class.java, "database-pokemon"
        ).build()

        return pokemonDb.pokemonDao()
    }
}