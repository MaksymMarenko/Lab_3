package com.example.catimages.infrastructure

import com.example.catimages.data.CatResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("v1/images/search")
    suspend fun getCatImage(): Response<List<CatResponse>>
}
