package com.android.lab.data.remote.models

import com.android.lab.data.remote.models.PokemonRemote

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


