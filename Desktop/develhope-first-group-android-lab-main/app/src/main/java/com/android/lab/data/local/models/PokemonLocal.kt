package com.android.lab.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.lab.domain.models.Pokemon

@Entity(tableName = "pokemon")
data class PokemonLocal(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image_url") val imageUrl: String,
)

fun PokemonLocal.toPokemon() = Pokemon(name, imageUrl)

fun List<PokemonLocal>.toPokemonList() = map { it.toPokemon() }

fun Pokemon.toLocal() = PokemonLocal(name.lowercase(), name, sprite)

fun List<Pokemon>.toLocalList() = map { it.toLocal() }
