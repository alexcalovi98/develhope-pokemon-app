package com.android.lab.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.lab.data.local.models.PokemonLocal

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon") //table name pokemon set on PokemonLocal line 7, @Entity(tableName = "pokemon")
    suspend fun getAll(): List<PokemonLocal>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pokemon: List<PokemonLocal>)
}