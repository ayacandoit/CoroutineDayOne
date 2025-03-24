package com.example.coroutinesdemo

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

fun getFruits() = flow<String> {
    val fruits = listOf("Apple", "Kiwi", "Orange", "Strawberry")
    for (fruit in fruits) {
        delay(500)
        emit(fruit)
    }
}


suspend fun main() = coroutineScope {
    getFruits().collect { fruit ->
        println(fruit)

    }

}