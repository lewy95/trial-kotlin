package cn.xzxy.lewy.function

/**
 * 函数式编程的一些案例
 */

fun main() {

  val strArr = arrayOf("ym", "yy", "sy", "ly", "qn", "mc")

  val filtered = strArr.filter { it.contains("y") }
  println(filtered)

  val filtered2 = strArr.filter { it.length > 1 }
  println(filtered2)

  val filtered3 = strArr.filter { it.endsWith("y") }.map { it.toUpperCase() }
  println(filtered3)

  val filtered4 = strArr.filter {
    it.length < 3
    // lambda 表达式最后一行可以作为返回值
  }
  println(filtered4)

  val filtered5 = strArr.filter {
    return@filter it.length < 3
    // lambda 表达式最后一行可以作为返回值，如果硬要用return，需要加上@方法名
  }
  println(filtered5)

}