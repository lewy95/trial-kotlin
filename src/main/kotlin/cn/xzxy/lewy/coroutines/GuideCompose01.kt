package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * 默认顺序调用
 * 实际上，若要根据第一个函数的结果来决定是否需要调用第二个函数或者决定如何调用它时，才会这样做。
 * 使用普通的顺序来进行调用，因为这些代码是运行在协程中的，只要像常规的代码一样顺序都是默认的。
 * 下例中展示了测量执行两个挂起函数所需要的总时间。
 */
fun main() = runBlocking {
  val time = measureTimeMillis {
    // 顺序执行，先执行one再执行two
    val one = tryOne()
    val two = tryTwo()
    println("The answer is ${one + two}")
  }
  println("Completed in $time ms")
}

suspend fun tryOne(): Int {
  delay(1000L) // pretend we are doing something useful here
  return 13
}

suspend fun tryTwo(): Int {
  delay(1000L) // pretend we are doing something useful here, too
  return 29
}

// The answer is 42
// Completed in 2009 ms
