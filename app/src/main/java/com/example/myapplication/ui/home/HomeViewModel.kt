package com.example.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.koin.core.component.*
import org.koin.core.parameter.parametersOf
import org.koin.core.scope.Scope

class HomeViewModel : ViewModel(), KoinScopeComponent {
    override val scope: Scope by lazy { createScope(this) }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    val randomGenerator: RandomGenerator by scope.inject {
        println("injection: inject $viewModelScope")
        parametersOf(viewModelScope)
    }

    fun callHomePageResolver() {
        randomGenerator.doSomething()
    }

    override fun onCleared() {
        super.onCleared()
        scope.close()
        println("injection: onCleared called")
    }
}