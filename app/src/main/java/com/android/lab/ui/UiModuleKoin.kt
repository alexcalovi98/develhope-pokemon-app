package com.android.lab.ui

import com.android.lab.ui.main.home.HomeViewModel
import com.android.lab.ui.main.pokemon.PokemonViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { PokemonViewModel(get()) }
}