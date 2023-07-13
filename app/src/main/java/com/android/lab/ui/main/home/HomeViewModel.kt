package com.android.lab.ui.main.home

import androidx.lifecycle.ViewModel
import com.android.lab.data.local.PokemonPreferences

class HomeViewModel(
    private val pokemonPreferences: PokemonPreferences
): ViewModel() {

    fun getUserName() = pokemonPreferences.getUserName()

    fun saveUserName(userName: String) = pokemonPreferences.saveUserName(userName)

    companion object {
        private val TAG = HomeViewModel::class.java.simpleName
    }
}