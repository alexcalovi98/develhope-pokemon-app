package com.android.lab.ui.main.pokemon

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.lab.data.PokeAPI
import com.android.lab.data.PokemonResultRemote
import com.android.lab.ui.main.pokemon.adapter.PokemonItem
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonViewModel: ViewModel() {

    private val pokeAPI: PokeAPI

    val pokemonLiveData = MutableLiveData<List<PokemonItem>>()

    init {
        //Retrofit client creation
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        pokeAPI = retrofit.create(PokeAPI::class.java)
    }

    fun downloadPokemon() {
        viewModelScope.launch {
            val pokemonResult = pokeAPI.getPokemon(20, 0)
            val pokemonItems = pokemonItems(pokemonResult)

            Log.d(TAG, "$pokemonItems")

            //Update pokemon list
            pokemonLiveData.postValue(pokemonItems)
        }
    }

    private suspend fun pokemonItems(pokemonResult: PokemonResultRemote): List<PokemonItem> {
        val pokemonItems = mutableListOf<PokemonItem>()
        pokemonResult.results.forEach {
            val d = pokeAPI.getPokemonDetails(it.name)
            pokemonItems.add(PokemonItem(
                d.sprites.other.dreamWorld.frontDefault,
                it.name.replaceFirstChar { c -> c.uppercase() }
            ))
        }
        return pokemonItems
    }

    companion object {
        private val TAG = PokemonViewModel::class.java.simpleName
    }

}