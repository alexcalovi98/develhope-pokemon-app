package com.android.lab.repository

import com.google.gson.annotations.SerializedName

data class PokemonDetailsRemote(private val sprites: SpritesRemote)

data class SpritesRemote(private val other: OtherRemote)

data class OtherRemote(@SerializedName("dream_world") private val dreamWorld: DreamWorldRemote)

data class DreamWorldRemote(@SerializedName("front_default") private val frontDefault: String)git