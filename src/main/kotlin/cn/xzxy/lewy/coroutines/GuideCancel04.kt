package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 在finally中释放资源
 * 使用如下的方法处理在被取消时抛出 CancellationException 的可被取消的挂起函数。
 * 比如说，try {……} finally {……} 表达式以及 Kotlin 的 use 函数一般在协程被取消的时候执行它们的终结动作
 */
fun main() = runBlocking {
  val job = launch {
    try {
      repeat(1000) { i ->
        println("job: I'm sleeping $i ...")
        delay(500L)
      }
    } finally {
      println("job: I'm running finally")
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
// job: I'm running finally
// main: Now I can quit.