package cn.xzxy.lewy.garmmar

/**
 * if 语法
 */
fun statementIf(a: Int, b: Int): Int {
  // return if (a > b) a else b

  // val min = if (a < b) a else b
  // println("min = $min")

  return if (a > b) {
    println(a)
    a // 最后一行作为返回值
  } else {
    println(b)
    b
  }
}

fun main() {
  statementIf(1, 2)
}