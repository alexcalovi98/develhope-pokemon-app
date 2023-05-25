package com.android.lab.repository

import retrofit2.http.GET
import retrofit2.http.Path

interface PokeAPI {

    @GET("pokemon")
    suspend fun getPokemon(): PokemonResultRemote

    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(@Path("name") name: String): PokemonDetailsRemote
}