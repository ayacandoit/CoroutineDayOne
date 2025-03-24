package com.example.coroutinesdemo

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
fun getDays() = GlobalScope.produce<String> {
    val days = listOf("sat", "sun", "mon", "tue", "wed", "thu", "fri")
    for (day in days) {
        delay(500)
        send(day)
    }

    close()
}

fun main() = runBlocking {
    val days = getDays()
    days.consumeEach { day ->
        println(day)
    }
}

