package com.android.lab.ui.main.pokemon

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.lab.data.PokemonRepository
import com.android.lab.ui.main.pokemon.adapter.PokemonItem
import kotlinx.coroutines.launch

class PokemonViewModel: ViewModel() {

    private val repository = PokemonRepository()

    val pokemonLiveData = MutableLiveData<List<PokemonItem>>()

    fun downloadPokemon() {
        viewModelScope.launch {
            val pokemonItems = repository.getPokemon(20, 0)

            Log.d(TAG, "$pokemonItems")

            //Update pokemon list
            pokemonLiveData.postValue(pokemonItems)
        }
    }

    companion object {
        private val TAG = PokemonViewModel::class.java.simpleName
    }
}