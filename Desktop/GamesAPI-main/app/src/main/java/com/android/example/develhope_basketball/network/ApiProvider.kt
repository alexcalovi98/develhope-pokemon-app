package com.android.example.develhope_basketball.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiProvider {
    private val baseUrl = "https://dad-jokes.p.rapidapi.com/"
    private val apiKey = "cb3194a9cfmshd485632ea2d0117p1582b5jsn3b9f04198f13"
    private val host = "dad-jokes.p.rapidapi.com"

    private val client = OkHttpClient.Builder()
        .addInterceptor(GamesInterceptor(apiKey, host))
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val api = retrofit.create(ApiService::class.java)
}

class GamesInterceptor(private val apiKey : String, private val hostUrl : String): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val keyRequest = request.newBuilder()
            .addHeader("X-RapidAPI-Key", apiKey)
            .addHeader("X-RapidAPI-Host",hostUrl)
            .build()
        return chain.proceed(keyRequest)
    }
}