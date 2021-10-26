package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
  launch { // 在 runBlocking 作用域中启动一个新协程
    delay(1000L)
    println("World!1")
  }
  launch() { // 在 runBlocking 作用域中启动一个新协程
    delay(900L)
    println("World!2")
  }
  println("Hello,")
  println("Done")
}

// 结构化并发