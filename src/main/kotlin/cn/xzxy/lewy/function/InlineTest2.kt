package cn.xzxy.lewy.function

/**
 * noinline：排除内联
 * 将内联代码块，传递个另一个没有 inline 修饰的方法将会提示错误。
 */
inline fun addUp2(a: Int, b: Int, noinline sum: (sum: Int) -> Unit) {
  println("内联函数 sum 执行前")
  check2(sum) // 不加 noinline 会报错
  println("内联函数 sum 执行后")
}

// 如果被调用的 check 有 inline 修饰，是没有问题的
//inline fun check(sum: (i: Int) -> Unit) {
//  println("另一个内联函数")
//  sum(20)
//}

// 如果被调用的 check 没有 inline 修饰，需要加上 noinline
fun check2(sum: (i: Int) -> Unit) {
  println("另一个内联函数")
  sum(20)
}

fun main(args: Array<String>) {
  val a = 10
  val b = 20
  addUp2(a, b) {
    println("内联函数 sum 执行结果：$it")
  }
}