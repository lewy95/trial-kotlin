package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

// note that we don't have `runBlocking` to the right of `main` in this example
fun main() {
  val time = measureTimeMillis {
    // we can initiate async actions outside of a coroutine
    val one = somethingUsefulOneAsync()
    val two = somethingUsefulTwoAsync()
    // but waiting for a result must involve either suspending or blocking.
    // here we use `runBlocking { ... }` to block the main thread while waiting for the result
    runBlocking {
      println("The answer is ${one.await() + two.await()}")
    }
  }
  println("Completed in $time ms")
}

/**
 * 可以定义异步风格的函数来异步的调用下面方法，并使用 async 协程建造器并带有一个显式的 GlobalScope 引用。
 * 给这样的函数的名称中加上 "……Async" 后缀来突出表明：事实上，它们只做异步计算并且需要使用延期的值来获得结果。
 */
fun somethingUsefulOneAsync() = GlobalScope.async {
  doSomethingUsefulOne()
}

fun somethingUsefulTwoAsync() = GlobalScope.async {
  doSomethingUsefulTwo()
}

suspend fun doSomethingUsefulOne(): Int {
  delay(1000L) // pretend we are doing something useful here
  return 13
}

suspend fun doSomethingUsefulTwo(): Int {
  delay(1000L) // pretend we are doing something useful here, too
  return 29
}

// The answer is 42
// Completed in 1052 ms
