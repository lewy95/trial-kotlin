package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.*

/**
 * 协程的取消是有条件的（必须是协作的）。
 * 所有 kotlinx.coroutines 中的挂起函数都是可被取消的。
 * 它们检查协程的取消，并在取消时抛出 CancellationException。
 * 然而，如果协程正在执行计算任务，并且没有检查取消的话，那么它是不能被取消的，如下所示：
 */
fun main() = runBlocking {
  val startTime = System.currentTimeMillis()
  val job = launch(Dispatchers.Default) {
    var nextPrintTime = startTime
    var i = 0
    while (i < 5) { // computation loop, just wastes CPU
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

// job: I'm sleeping 0 ...
// job: I'm sleeping 1 ...
// job: I'm sleeping 2 ...
// main: I'm tired of waiting!
// job: I'm sleeping 3 ...
// job: I'm sleeping 4 ...
// main: Now I can quit.
