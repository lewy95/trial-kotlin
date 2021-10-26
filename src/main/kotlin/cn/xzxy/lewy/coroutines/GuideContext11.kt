package cn.xzxy.lewy.coroutines

import kotlinx.coroutines.*

val threadLocal = ThreadLocal<String?>() // declare thread-local variable

fun main() = runBlocking {
  threadLocal.set("main")
  println("Pre-main, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
  val job = launch(Dispatchers.Default + threadLocal.asContextElement(value = "launch")) {
    println("Launch start, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
    yield()
    println("After yield, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
  }
  job.join()
  println("Post-main, current thread: ${Thread.currentThread()}, thread local value: '${threadLocal.get()}'")
}

// Pre-main, current thread: Thread[main,5,main], thread local value: 'main'
// Launch start, current thread: Thread[DefaultDispatcher-worker-1,5,main], thread local value: 'launch'
// After yield, current thread: Thread[DefaultDispatcher-worker-1,5,main], thread local value: 'launch'
// Post-main, current thread: Thread[main,5,main], thread local value: 'main'
