package com.example.catimages.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catimages.data.CatResponse
import com.example.catimages.infrastructure.MyRepository
import kotlinx.coroutines.launch

class MyViewModel(private val repository: MyRepository): ViewModel() {
    val catImage = MutableLiveData<CatResponse>()

    init {
        updateCatImage()
    }

    constructor() : this(MyRepository())

    fun updateCatImage() {
        viewModelScope.launch {
            val response = repository.getCatImage()
            if (response.isSuccessful) {
                catImage.value = response.body()?.first()
            }
        }
    }
}

