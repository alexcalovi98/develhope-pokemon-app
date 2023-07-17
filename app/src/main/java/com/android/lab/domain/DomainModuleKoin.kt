package com.android.lab.domain

import com.android.lab.domain.usecase.GetPokemonUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetPokemonUseCase(get()) }
}

