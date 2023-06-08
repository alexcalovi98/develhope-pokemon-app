package com.android.lab.data

import com.google.gson.annotations.SerializedName

data class PokemonDetailsRemote(
    val sprites: SpritesRemote, val abilities: List<AbilityRemote>
)

data class SpritesRemote(val other: OtherRemote)
data class OtherRemote(@SerializedName("dream_world") val dreamWorld: DreamWorldRemote)
data class DreamWorldRemote(@SerializedName("front_default") val frontDefault: String)

data class AbilityRemote(val ability: AbilityNameRemote)
data class AbilityNameRemote(val name: String)