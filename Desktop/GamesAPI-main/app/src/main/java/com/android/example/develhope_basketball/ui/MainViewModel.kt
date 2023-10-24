package com.android.example.develhope_basketball.ui

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.example.develhope_basketball.data.GameResponse
import com.android.example.develhope_basketball.network.ApiProvider
import kotlinx.coroutines.launch

private const val KEY = "string_key"
class MainViewModel(
    private val provider: ApiProvider,
    private val preferences: SharedPreferences
) : ViewModel() {
    val gameListLiveData = MutableLiveData<List<GameResponse>>()

    init {
       preferences.edit().putString(KEY,"Test").clear()
        val text = preferences.getString(KEY, "")
        Log.d("STRING", "TEXT = $text")
    }

    fun dataFetch() {

        viewModelScope.launch() {
            try {
                val response = provider.api.getGames()
                if (response.success) {
                    val setup = response.body[0]
                    gameListLiveData.postValue(listOf(setup))
                } else {
                    Log.d("Error", "Error API: $response")
                }
            } catch (e: Exception) {
                Log.d("Error", "Error API2: ${e.message}")
            }
        }
    }
}