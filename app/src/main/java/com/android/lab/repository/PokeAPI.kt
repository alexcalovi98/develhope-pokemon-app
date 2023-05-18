package com.android.lab.repository

import retrofit2.http.GET

interface PokeAPI {

    @GET("pokemon")
    suspend fun getPokemon(): PokemonResultRemote
}