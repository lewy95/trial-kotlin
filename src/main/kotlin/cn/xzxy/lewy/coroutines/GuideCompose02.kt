package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * 上例中，两个方法是顺序执行的，如果想要并发执行，则可以使用 async。
 * 在概念上，async 就类似于 launch，它启动了一个单独的协程，这是一个轻量级的线程并与其它所有的协程一起并发的工作。
 * 不同在于 launch 返回一个 Job 并且不附带任何结果值，而 async 返回一个 Deferred，是一个轻量级的非阻塞 future。
 * 可以使用 .await() 在一个延期的值上得到它的最终结果。此外，Deferred 也是一个 Job，所以如果需要的话，可以取消它。
 */
fun main() = runBlocking {
  val time = measureTimeMillis {
    val one = async { tryA() }
    val two = async { tryB() }
    println("The answer is ${one.await() + two.await()}")
  }
  println("Completed in $time ms")
}

suspend fun tryA(): Int {
  delay(1000L) // pretend we are doing something useful here
  return 13
}

suspend fun tryB(): Int {
  delay(1000L) // pretend we are doing something useful here, too
  return 29
}

// The answer is 42
// Completed in 1013 ms
