package cn.xzxy.lewy.function

/**
 * crossinline：既要内联，又要禁止非局部返回
 * 注意：加上 crossinline 关键字后，return 后面会强制指定退出当前内联函数，否则有语法问题
 */
inline fun addUp3(a: Int, b: Int, crossinline sum: (sum: Int) -> Unit) {
  println("内联方法 sum 执行前")
  sum(a + b)
  println("内联方法 sum 执行后")
}

fun main(args: Array<String>) {
  val a = 10
  val b = 20
  println("调用内联函数执行前")
  addUp3(a, b) {
    println("内联方法 sum 执行结果：$it")
    return@addUp3
  }
  println("调用内联函数执行后")
}





