package com.android.lab.data

import com.android.lab.data.local.PokemonDao
import com.android.lab.data.local.models.toLocalList
import com.android.lab.data.local.models.toPokemonList
import com.android.lab.data.remote.PokeAPI
import com.android.lab.domain.models.Pokemon

class PokemonRepository(
    private val pokeAPI: PokeAPI,
    private val pokemonDao: PokemonDao
) {

    suspend fun getPokemon(limit: Int, offset: Int): List<Pokemon> {
        return if(NetworkManager.isConnected) {
            val pokemonList = getPokemonFromRemote(limit, offset)
            pokemonDao.insert(pokemonList.toLocalList())
            pokemonList
        } else {
            pokemonDao.getAll().toPokemonList()
        }
    }

    private suspend fun getPokemonFromRemote(limit: Int, offset: Int): List<Pokemon> {
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