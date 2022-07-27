package com.example.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class HomeViewModel : ViewModel(), KoinComponent {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    val randomGenerator: RandomGenerator by inject() {
        println("injection: inject $viewModelScope")
        parametersOf(viewModelScope)
    }

    fun callHomePageResolver() {
        randomGenerator.doSomething()
    }

    override fun onCleared() {
        super.onCleared()
        println("injection: onCleared called")
    }
}