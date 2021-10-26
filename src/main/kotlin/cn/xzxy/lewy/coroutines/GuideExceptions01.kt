package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.*

/**
 * 被取消的协程会在挂起点抛出 CancellationException 并且它会被协程的机制所忽略。
 * 在取消过程中抛出异常或同一个协程的多个子协程抛出异常时会发生什么。
 */
fun main() = runBlocking {
    val job = GlobalScope.launch { // root coroutine with launch
        println("Throwing exception from launch")
        throw IndexOutOfBoundsException() // Will be printed to the console by Thread.defaultUncaughtExceptionHandler
    }
    job.join()
    println("Joined failed job")
    val deferred = GlobalScope.async { // root coroutine with async
        println("Throwing exception from async")
        throw ArithmeticException() // Nothing is printed, relying on user to call await
    }
    try {
        deferred.await()
    } catch (e: ArithmeticException) {
        println("Caught ArithmeticException")
    }
}
