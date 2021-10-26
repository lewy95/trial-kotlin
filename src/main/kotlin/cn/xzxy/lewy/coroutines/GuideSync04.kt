package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.*
import kotlin.system.*

suspend fun massiveRun4(action: suspend () -> Unit) {
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

val counterContext = newSingleThreadContext("CounterContext")
var counter4 = 0

fun main() = runBlocking {
  withContext(Dispatchers.Default) {
    massiveRun4 {
      // confine each increment to a single-threaded context
      withContext(counterContext) {
        counter4++
      }
    }
  }
  println("Counter = $counter4")
}
