package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.system.measureTimeMillis

suspend fun massiveRun6(action: suspend () -> Unit) {
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

val mutex = Mutex()
var counter6 = 0

fun main() = runBlocking {
  withContext(Dispatchers.Default) {
    massiveRun6 {
      // protect each increment with lock
      mutex.withLock {
        counter6++
      }
    }
  }
  println("Counter = $counter6")
}

// Completed 100000 actions in 134 ms
// Counter = 100000
