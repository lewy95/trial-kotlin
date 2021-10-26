package cn.xzxy.lewy.oop

/**
 * 属性委托之延迟属性
 * 延迟属性指的是属性只在第一次被访问的时候才会计算，之后则会将结果缓存起来供后续调用
 * LazyThreadSafetyMode:
 * 1. SYNCHRONIZED：默认地，延迟属性的值只会在一个线程中得到计算；
 * 2. PUBLICATION：如果不需要初始化委托的同步，这样多个线程可以同时执行；
 * 3. NONE：如果确定初始化操作只会在一个线程中执行，这样会减少建成安全方面的开销；
 */
val testLazyValue: Int by lazy (LazyThreadSafetyMode.NONE) {
    println("hello world")
    915
}

fun main() {
    println(testLazyValue)
    println(testLazyValue)
    // 只打印一次 hello world
}