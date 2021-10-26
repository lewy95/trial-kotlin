package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun massiveRun5(action: suspend () -> Unit) {
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

val counterContext5 = newSingleThreadContext("CounterContext")
var counter5 = 0

fun main() = runBlocking {
  // confine everything to a single-threaded context
  withContext(counterContext5) {
    massiveRun5 {
      counter5++
    }
  }
  println("Counter = $counter5")
}

// Completed 100000 actions in 23 ms
// Counter = 100000
