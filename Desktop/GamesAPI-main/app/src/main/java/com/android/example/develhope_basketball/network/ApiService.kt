package com.android.example.develhope_basketball.network

import com.android.example.develhope_basketball.data.GameResponse
import com.android.example.develhope_basketball.data.GamesJokes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("random/joke")
    suspend fun getGames(): GamesJokes
}




