package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
  val time = measureTimeMillis {
    println("The answer is ${concurrentSum()}")
  }
  println("Completed in $time ms")
}

/**
 * 这种方式，若在函数内部发生了错误，并且它抛出了一个异常，所有在作用域中启动的协程都会被取消。
 */
suspend fun concurrentSum(): Int = coroutineScope {
  val one = async { doUsefulOne() }
  val two = async { doUsefulTwo() }
  one.await() + two.await()
}

suspend fun doUsefulOne(): Int {
  delay(1000L) // pretend we are doing something useful here
  return 13
}

suspend fun doUsefulTwo(): Int {
  delay(1000L) // pretend we are doing something useful here, too
  return 29
}

// The answer is 42
// Completed in 1015 ms
