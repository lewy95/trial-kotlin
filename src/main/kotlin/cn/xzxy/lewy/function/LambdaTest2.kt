package cn.xzxy.lewy.function

/**
 * 高阶函数和lambda表达式
 */
val add: (Int, Int) -> Int = { a, b -> a + b }
val multiply: (Int, Int) -> Int = { a, b -> a * b }
val subtract = { a: Int, b: Int -> a + b }
val printInfo = { println("oo") }

val mayReturnNull: (Int, Int) -> Int? = { _, _ -> null }
val funcMaybeNull: ((Int, Int) -> Int)? = null

fun main() {

  add(1, 2)
  multiply(1, 2)
  subtract(1, 2)
  printInfo()

  mayReturnNull(1, 2)
  funcMaybeNull


}