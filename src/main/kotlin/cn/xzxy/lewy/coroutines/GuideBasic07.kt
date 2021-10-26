package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
  launch { doWorld() }
  println("Hello,")
}

// 第一个挂起函数
suspend fun doWorld() {
  delay(1000L)
  println("World!")
}