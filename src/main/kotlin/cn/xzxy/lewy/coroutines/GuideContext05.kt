package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
  println("My job is ${coroutineContext[Job]}")
}
