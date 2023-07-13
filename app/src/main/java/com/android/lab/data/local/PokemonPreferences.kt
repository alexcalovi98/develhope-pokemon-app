package com.android.lab.data.local

import android.content.SharedPreferences
import androidx.core.content.edit

class PokemonPreferences(
    private val sharedPreferences: SharedPreferences
) {

    fun saveUserName(userName: String) =
        sharedPreferences.edit {
            putString(USER_NAME_KEY, userName)
            apply()
        }

    fun getUserName() = sharedPreferences.getString(USER_NAME_KEY, null)

    companion object {
        private const val USER_NAME_KEY = "USER_NAME"
    }

}