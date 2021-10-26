package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/**
 * 超时：实践中绝大多数取消一个协程的理由是它有可能超时。
 * 当你手动追踪一个相关 Job 的引用并启动了一个单独的协程在延迟后取消追踪，这里已经准备好使用 withTimeout 函数来做这件事。
 */
fun main() = runBlocking {
  val result = withTimeoutOrNull(1300L) {
    repeat(1000) { i ->
      println("I'm sleeping $i ...")
      delay(500L)
    }
    "Done" // will get cancelled before it produces this result
  }
  println("Result is $result")
}
