package cn.xzxy.lewy.function

inline fun addUp(a: Int, b: Int, sum: (sum: Int) -> Unit) {
  println("内联函数 sum 执行前")
  sum(a + b)
  println("内联函数 sum 执行后")
}

fun main(args: Array<String>) {
  val a = 10
  val b = 20
  addUp(a, b) {
    println("内联函数 sum 执行结果：$it")
  }
}