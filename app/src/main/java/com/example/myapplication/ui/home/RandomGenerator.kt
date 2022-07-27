package com.example.myapplication.ui.home

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds

class RandomGenerator() {
    // This scope is initialized in the init of the HomeViewModel
    lateinit var scope: CoroutineScope

    private val _randomNumber = MutableStateFlow(Random.nextInt())
    val randomNumber: Flow<Int> = _randomNumber

    fun generate() {
        println("injection: RandomGenerate.generate ($scope) is active: ${scope.isActive}")
        scope.launch {
            delay(300.milliseconds)
            _randomNumber.value = Random.nextInt()
        }
    }
}