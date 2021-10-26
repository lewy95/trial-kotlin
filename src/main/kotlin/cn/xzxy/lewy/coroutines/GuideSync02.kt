package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun massiveRun2(action: suspend () -> Unit) {
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

@Volatile // in Kotlin `volatile` is an annotation
var counter2 = 0

fun main() = runBlocking {
  withContext(Dispatchers.Default) {
    massiveRun2 {
      counter2++
    }
  }
  println("Counter = $counter2")
}

// Completed 100000 actions in 17 ms
// Counter = 65839
