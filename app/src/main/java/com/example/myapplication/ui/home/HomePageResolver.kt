package com.example.myapplication.ui.home

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class HomePageResolver(private val scope: CoroutineScope) {

    fun doSomething() {
        println("navtest: scope is active ${scope.isActive}")
        scope.launch {
            delay(500.milliseconds)
            println("navtest: I did something")
        }
    }
}