package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

@ObsoleteCoroutinesApi
fun main() {
  newSingleThreadContext("Ctx1").use { ctx1 ->
    newSingleThreadContext("Ctx2").use { ctx2 ->
      runBlocking(ctx1) {
        log("Started in ctx1")
        withContext(ctx2) {
          log("Working in ctx2")
        }
        log("Back to ctx1")
      }
    }
  }
}
