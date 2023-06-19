package com.android.lab.domain.usecase

import com.android.lab.data.PokemonRepository

class GetPokemonUseCase {

    private val repository = PokemonRepository()

    suspend operator fun invoke(limit: Int, offset: Int) =
        repository.getPokemon(limit, offset)
}