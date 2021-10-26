package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun logger(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun main() = runBlocking {
  val a = async {
    logger("I'm computing a piece of the answer")
    6
  }
  val b = async {
    logger("I'm computing another piece of the answer")
    7
  }
  logger("The answer is ${a.await() * b.await()}")
}

// [main] I'm computing a piece of the answer
// [main] I'm computing another piece of the answer
// [main] The answer is 42