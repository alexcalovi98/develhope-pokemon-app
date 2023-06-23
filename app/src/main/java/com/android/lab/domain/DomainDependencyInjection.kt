package com.android.lab.domain

import com.android.lab.data.DataDependencyInjection
import com.android.lab.domain.usecase.GetPokemonUseCase

object DomainDependencyInjection {

    val getPokemonUseCase = GetPokemonUseCase(
        DataDependencyInjection.pokemonRepository
    )
}