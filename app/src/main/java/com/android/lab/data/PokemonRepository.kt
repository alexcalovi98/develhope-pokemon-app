package com.android.lab.data

import com.android.lab.ui.main.pokemon.adapter.PokemonItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonRepository {

    private val pokeAPI: PokeAPI

    init {
        //Retrofit client creation
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        pokeAPI = retrofit.create(PokeAPI::class.java)
    }

    suspend fun getPokemon(limit: Int, offset: Int): List<PokemonItem> {
        val pokemonResult = pokeAPI.getPokemon(limit, offset)
        val pokemonItems = mutableListOf<PokemonItem>()
        pokemonResult.results.forEach {
            val pokemonDetails = pokeAPI.getPokemonDetails(it.name)
            pokemonItems.add(PokemonItem(
                pokemonDetails.sprites.other.dreamWorld.frontDefault,
                it.name.replaceFirstChar { c -> c.uppercase() }
            ))
        }
        return pokemonItems
    }
}