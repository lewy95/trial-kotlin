package cn.xzxy.lewy.function

/**
 * 匿名函数：没有名称
 * 注意：匿名函数只能存在与()中，不能用{}，这一点与lambda不同
 */
fun main() {
  // fun(x: Int, y: Int) = x + y

  // fun(x: Int, y: Int): Int {
  //     return x + y
  // }

  val strArr = arrayOf("yy", "ym", "sy")
  strArr.filter(fun(item): Boolean = item.startsWith("y")).forEach { println(it) }

  val l1 = listOf("a", "b", "c")
  val l2 = listOf(1, 2, 3)
  val merged = l1 zip l2
  println(merged.first().first) // a
  val filtered = merged.filterNot(fun(tuple): Boolean = tuple.first == "a")
  println(filtered)

}