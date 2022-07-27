package com.example.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : ViewModel(), KoinComponent {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    val randomGenerator: RandomGenerator by inject()

    init {
        println("injection: HomeViewModel.init set viewModelScope to $viewModelScope")
        randomGenerator.scope = viewModelScope
    }

    fun generate() {
        println("injection: HomeViewModel.generate randomGenerator instance is $randomGenerator")
        randomGenerator.generate()
    }

    override fun onCleared() {
        super.onCleared()
        println("injection: HomeViewModel.onCleared")
    }
}