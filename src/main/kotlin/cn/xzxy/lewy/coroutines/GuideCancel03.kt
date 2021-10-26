package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.*

/**
 * 上例中说到 如果协程正在执行计算任务，并且没有检查取消的话，那么它是不能被取消的。
 * 但也有两种方法来使执行计算的代码可以被取消。
 * 1. 定期调用挂起函数来检查取消，对于这种目的 yield 是一个好的选择；
 * 2. 显式的检查取消状态；
 */
fun main() = runBlocking {
  val startTime = System.currentTimeMillis()
  val job = launch(Dispatchers.Default) {
    var nextPrintTime = startTime
    var i = 0
    while (isActive) { // cancellable computation loop
      // print a message twice a second
      if (System.currentTimeMillis() >= nextPrintTime) {
        println("job: I'm sleeping ${i++} ...")
        nextPrintTime += 500L
      }
    }
  }
  delay(1300L) // delay a bit
  println("main: I'm tired of waiting!")
  job.cancelAndJoin() // cancels the job and waits for its completion
  println("main: Now I can quit.")
}

// ob: I'm sleeping 0 ...
// job: I'm sleeping 1 ...
// job: I'm sleeping 2 ...
// main: I'm tired of waiting!
// main: Now I can quit.
