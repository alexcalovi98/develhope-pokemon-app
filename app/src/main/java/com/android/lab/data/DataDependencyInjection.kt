package com.android.lab.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataDependencyInjection {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val pokeApi = retrofit.create(PokeAPI::class.java)

    val pokemonRepository = PokemonRepository(pokeApi)
}