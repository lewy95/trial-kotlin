package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun logObj(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun main() = runBlocking(CoroutineName("main")) {
  logObj("Started main coroutine")
  // run two background value computations
  val v1 = async(CoroutineName("v1coroutine")) {
    delay(500)
    logObj("Computing v1")
    252
  }
  val v2 = async(CoroutineName("v2coroutine")) {
    delay(1000)
    logObj("Computing v2")
    6
  }
  logObj("The answer for v1 / v2 = ${v1.await() / v2.await()}")
}

// [main] Started main coroutine
// [main] Computing v1
// [main] Computing v2
// [main] The answer for v1 / v2 = 42