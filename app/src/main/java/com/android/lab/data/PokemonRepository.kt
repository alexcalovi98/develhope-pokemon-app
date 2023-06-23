package com.android.lab.data

import com.android.lab.domain.models.Pokemon
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonRepository(private val pokeAPI: PokeAPI) {

    suspend fun getPokemon(limit: Int, offset: Int): List<Pokemon> {
        val pokemonResult = pokeAPI.getPokemon(limit, offset)
        val pokemonList = mutableListOf<Pokemon>()
        pokemonResult.results.forEach {
            val pokemonDetails = pokeAPI.getPokemonDetails(it.name)
            pokemonList.add(Pokemon(
                it.name,
                pokemonDetails.sprites.other.dreamWorld.frontDefault
            ))
        }
        return pokemonList
    }
}