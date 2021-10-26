package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun massiveRun(action: suspend () -> Unit) {
  val n = 100  // number of coroutines to launch
  val k = 1000 // times an action is repeated by each coroutine
  val time = measureTimeMillis {
    coroutineScope { // scope for coroutines
      repeat(n) {
        launch {
          repeat(k) { action() }
        }
      }
    }
  }
  println("Completed ${n * k} actions in $time ms")
}

var counter = 0

fun main() = runBlocking {
  withContext(Dispatchers.Default) {
    massiveRun {
      counter++
    }
  }
  println("Counter = $counter")
}

// Completed 100000 actions in 15 ms
// Counter = 55094
