package com.android.lab.ui.main.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.lab.domain.DomainDependencyInjection

class PokemonViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PokemonViewModel(
            DomainDependencyInjection.getPokemonUseCase
        ) as T
    }
}