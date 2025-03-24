package com.example.coroutinesdemo

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take

fun getEven() = flow<Int> {
    for (num in 2..40 step 2) {
            delay(500)
            emit(num)
    }
}

suspend fun main() = coroutineScope {
    getEven()
        .take(10)
        .collect { even ->
            println(even)
        }
}