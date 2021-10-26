package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 取消协程的执行
 * 在一个长时间运行的应用程序中，我们可能需要对后台协程进行取消。
 * 该 launch 函数返回了一个可以被用来取消运行中的协程的 Job。
 */
fun main() = runBlocking {
  val job = launch {
    repeat(1000) { i ->
      println("job: I'm sleeping $i ...")
      delay(500L)
    }
  }
  delay(1300L) // delay a bit 延迟一段时间
  println("main: I'm tired of waiting!")
  job.cancel() // cancels the job 取消该作业
  job.join() // waits for job's completion 等待作业执行结束
  println("main: Now I can quit.")
}

// job: I'm sleeping 0 ...
// job: I'm sleeping 1 ...
// job: I'm sleeping 2 ...
// main: I'm tired of waiting!
// main: Now I can quit.
