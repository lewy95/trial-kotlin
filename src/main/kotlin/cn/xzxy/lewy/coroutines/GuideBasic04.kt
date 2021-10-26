package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
  val job = GlobalScope.launch { // 启动一个子协程并保持对这个作业的引用
    delay(1000L)
    println("World!")
  }
  println("Hello,")
  job.join() // 等待直到子协程执行结束
  println("Done")
}

//Hello,
//World!
//Done

// join 显式（以非阻塞方式）等待所启动的后台 Job 执行结束