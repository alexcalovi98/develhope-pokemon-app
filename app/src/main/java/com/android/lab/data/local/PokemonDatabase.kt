package com.android.lab.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.lab.data.local.models.PokemonLocal

@Database(entities = [PokemonLocal::class], version = 1)
abstract class PokemonDatabase: RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}