package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * 惰性启动的 async
 * async 可以通过将 start 参数设置为 CoroutineStart.LAZY 而变为惰性的。
 * 在这个模式下，只有结果通过 await 获取的时候协程才会启动，或者在 Job 的 start 函数调用的时候。
 */
fun main() = runBlocking {
  val time = measureTimeMillis {
    val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulA() }
    val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulB() }
    // some computation
    // one.start() // start the first one
    // two.start() // start the second one
    println("The answer is ${one.await() + two.await()}")
  }
  println("Completed in $time ms")
}

suspend fun doSomethingUsefulA(): Int {
  delay(1000L) // pretend we are doing something useful here
  return 13
}

suspend fun doSomethingUsefulB(): Int {
  delay(1000L) // pretend we are doing something useful here, too
  return 29
}

// The answer is 42
// Completed in 1012 ms
