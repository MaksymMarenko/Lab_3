package com.example.catimages.data

data class CatResponse(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int,
    val breeds: List<Breed>
)

data class Breed(
    val name: String,
    val description: String
)

