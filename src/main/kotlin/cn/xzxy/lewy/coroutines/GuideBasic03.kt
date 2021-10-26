package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking { // 开始执行主协程
  GlobalScope.launch { // 在后台启动一个新的协程并继续
    delay(1000L)
    println("World!")
  }
  println("Hello,") // 主协程在这里会立即执行
  delay(2000L) // 延迟 2 秒来保证 JVM 存活
  println("Done")
}

//Hello,
//World!
//Done

// 02的另一种写法，使用 runBlocking 来包装 main 函数