package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

var acquired2 = 0

class Resource2 {
  init {
    acquired2++
  } // Acquire the resource

  fun close() {
    acquired2--
  } // Release the resource
}

fun main() {
  runBlocking {
    repeat(100_000) { // Launch 100K coroutines
      launch {
        var resource: Resource2? = null // Not acquired yet
        try {
          withTimeout(60) { // Timeout of 60 ms
            delay(50) // Delay for 50 ms
            resource = Resource2() // Store a resource to the variable if acquired
          }
          // We can do something else with the resource here
        } finally {
          resource?.close() // Release the resource if it was acquired
        }
      }
    }
  }
  // Outside of runBlocking all coroutines have completed
  println(acquired) // Print the number of resources still acquired
}
