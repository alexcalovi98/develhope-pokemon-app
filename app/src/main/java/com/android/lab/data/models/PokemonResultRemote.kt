package com.android.lab.data.models

import com.android.lab.data.models.PokemonRemote

data class PokemonResultRemote(
    val results: List<PokemonRemote>
)
/*
PokemonResultRemote {
    "results": List<PokemonRemote> [
        PokemonRemote {
            "name": "bulbasaur"
        },
        PokemonRemote {
            "name": "ivysaur"
        },
        ...
    ]
}*/


