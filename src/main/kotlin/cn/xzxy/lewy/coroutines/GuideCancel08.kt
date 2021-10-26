package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

/**
 * 异步超时和资源
 * withTimeout 中的超时事件与其块中运行的代码是异步的，并且可能随时发生，甚至在从超时块内部返回之前。
 * 如果在块内打开或获取某些需要在块外关闭或释放的资源，请记住这一点。
 * 下例中，用 Resource 类模拟了一个可关闭的资源，它通过增加获取的计数器并从其关闭函数中减少这个计数器来简单地跟踪它被创建的次数。
 * 让用小超时运行很多协程，尝试在一段时间后从 withTimeout 块内部获取此资源并从外部释放它。
 */

var acquired = 0

class Resource {
  init {
    acquired++
  } // Acquire the resource

  fun close() {
    acquired--
  } // Release the resource
}

fun main() {
  runBlocking {
    repeat(100_000) { // Launch 100K coroutines
      launch {
        val resource = withTimeout(60) { // Timeout of 60 ms
          delay(50) // Delay for 50 ms
          Resource() // Acquire a resource and return it from withTimeout block
        }
        resource.close() // Release the resource
      }
    }
  }
  // Outside of runBlocking all coroutines have completed
  println(acquired) // Print the number of resources still acquired
}

// 0
