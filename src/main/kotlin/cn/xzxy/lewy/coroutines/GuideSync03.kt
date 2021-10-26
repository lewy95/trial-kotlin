package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

suspend fun massiveRun3(action: suspend () -> Unit) {
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

val counter3 = AtomicInteger()

fun main() = runBlocking {
  withContext(Dispatchers.Default) {
    massiveRun3 {
      counter3.incrementAndGet()
    }
  }
  println("Counter = $counter3")
}
