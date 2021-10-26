package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 非受限调度器和受限调度器
 * Dispatchers.Unconfined 非受限协程调度器在调用它的线程启动了一个协程，但它仅仅只是运行到第一个挂起点。
 * 挂起后，它恢复线程中的协程，而这完全由被调用的挂起函数来决定。
 * 非受限的调度器非常适用于执行不消耗 CPU 时间的任务，以及不更新局限于特定线程的任何共享数据（如UI）的协程。
 * 此外，该调度器默认继承了外部的 CoroutineScope。
 * runBlocking 协程的默认调度器，特别是，当它被限制在了调用者线程时，继承自它将会有效地限制协程在该线程运行并且具有可预测的 FIFO 调度。
 */
fun main() = runBlocking<Unit> {
  launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
    println("Unconfined      : I'm working in thread ${Thread.currentThread().name}")
    delay(500)
    println("Unconfined      : After delay in thread ${Thread.currentThread().name}")
  }
  // 所以，该协程的上下文继承自 runBlocking {...} 协程并在 main 线程中运行，当 delay 函数调用的时候，非受限的那个协程在默认的执行者线程中恢复执行。
  launch { // context of the parent, main runBlocking coroutine
    println("main runBlocking: I'm working in thread ${Thread.currentThread().name}")
    delay(1000)
    println("main runBlocking: After delay in thread ${Thread.currentThread().name}")
  }
}

// Unconfined      : I'm working in thread main
// main runBlocking: I'm working in thread main
// Unconfined      : After delay in thread kotlinx.coroutines.DefaultExecutor
// main runBlocking: After delay in thread main
