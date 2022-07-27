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

    private val homePageResolver: HomePageResolver by inject()

    init {
        println("navtest: INIT in viewmodel $this")
        homePageResolver.scope = viewModelScope
    }

    fun callHomePageResolver() {
        homePageResolver.doSomething()
    }

    override fun onCleared() {
        super.onCleared()
        println("navtest: HomeViewModel.onCleared")
    }
}