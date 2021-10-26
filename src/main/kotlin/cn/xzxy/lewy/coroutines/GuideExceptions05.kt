package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.*
import java.io.IOException

fun main() = runBlocking {
  val handler = CoroutineExceptionHandler { _, exception ->
    println("CoroutineExceptionHandler got $exception with suppressed ${exception.suppressed.contentToString()}")
  }
  val job = GlobalScope.launch(handler) {
    launch {
      try {
        delay(Long.MAX_VALUE) // it gets cancelled when another sibling fails with IOException
      } finally {
        throw ArithmeticException() // the second exception
      }
    }
    launch {
      delay(100)
      throw IOException() // the first exception
    }
    delay(Long.MAX_VALUE)
  }
  job.join()
}
