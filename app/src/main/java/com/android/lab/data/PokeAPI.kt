package com.android.lab.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeAPI {

    @GET("pokemon")
    suspend fun getPokemon(@Query("limit") limit: Int, @Query("offset") offset: Int): PokemonResultRemote

    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(@Path("name") name: String): PokemonDetailsRemote
}