package com.example.catimages.infrastructure

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRepository {
    private val apiService = Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    suspend fun getCatImage() = apiService.getCatImage()
}
