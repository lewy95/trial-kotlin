package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.*

/**
 * 运行不能取消的代码块
 * 上例中任何尝试在 finally 块中调用挂起函数的行为都会抛出 CancellationException，因为这里持续运行的代码是可以被取消的。
 * 通常，这并不是一个问题，所有良好的关闭操作（关闭一个文件、取消一个作业等）通常都是非阻塞的，且不会调用任何挂起函数。
 * 然而，事实情况，当需要挂起一个被取消的协程时，可以将相应的代码包装在 withContext(NonCancellable) {……} 中，
 * 并使用 withContext 函数以及 NonCancellable 上下文。
 */
fun main() = runBlocking {
  val job = launch {
    try {
      repeat(1000) { i ->
        println("job: I'm sleeping $i ...")
        delay(500L)
      }
    } finally {
      withContext(NonCancellable) {
        println("job: I'm running finally")
        delay(1000L)
        println("job: And I've just delayed for 1 sec because I'm non-cancellable")
      }
    }
  }
  delay(1300L) // delay a bit
  println("main: I'm tired of waiting!")
  job.cancelAndJoin() // cancels the job and waits for its completion
  println("main: Now I can quit.")
}

// job: I'm sleeping 0 ...
// job: I'm sleeping 1 ...
// job: I'm sleeping 2 ...
// main: I'm tired of waiting!
// job: I'm running finally
// job: And I've just delayed for 1 sec because I'm non-cancellable
// main: Now I can quit.
