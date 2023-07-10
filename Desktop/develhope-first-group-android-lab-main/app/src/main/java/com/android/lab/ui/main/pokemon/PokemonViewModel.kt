package com.android.lab.ui.main.pokemon

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.lab.domain.usecase.GetPokemonUseCase
import com.android.lab.ui.main.pokemon.adapter.PokemonItem
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val getPokemonUseCase: GetPokemonUseCase
): ViewModel() {

    val pokemonLiveData = MutableLiveData<List<PokemonItem>>()

    fun downloadPokemon() {
        viewModelScope.launch {
            val pokemonList = getPokemonUseCase(20, 0)

            val pokemonItems = pokemonList.map {
                PokemonItem(
                    it.sprite,
                    it.name.replaceFirstChar { c -> c.uppercase() }
                )
            }

            Log.d(TAG, "$pokemonList")

            //Update pokemon list
            pokemonLiveData.postValue(pokemonItems)
        }
    }

    companion object {
        private val TAG = PokemonViewModel::class.java.simpleName
    }
}