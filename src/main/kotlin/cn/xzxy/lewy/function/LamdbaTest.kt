package cn.xzxy.lewy.function

/**
 * 高阶函数和lambda表达式
 *
 * 以 fold 方法为例：
 * 返回值是R，它接受两个参数：
 * 1. 初始累计值 initial: R
 * 2. 接合函数（lambda表达式）：combine: (acc: R, nextElement: T) -> R
 *    combine本质就是（R,T）-> R
 */
fun <T, R> Collection<T>.fold(
  initial: R,
  combine: (acc: R, nextElement: T) -> R
): R {
  var accumulator: R = initial
  for (element: T in this) {
    accumulator = combine(accumulator, element)
  }
  return accumulator
}

fun main() {
  val items = listOf(1, 2, 3, 4, 5)

  items.fold(0, {
    // Lambdas 表达式是花括号括起来的代码块
    // 若一个 lambda 表达式有参数，则 "类型 -> 函数体"
    // kotlin中 lambda 表达式的类型上不需要加圆括号
      acc: Int, i: Int ->
    print("acc = $acc, i = $i, ")
    val result = acc + i
    println("result = $result")
    // lambda 表达式中的最后一个表达式是返回值
    result
  })

  println("------------------------")

  // lambda 表达式的参数类型是可选的，如果能够推断出来的话：
  val joinedToString = items.fold("Elements:", { acc, i -> "$acc $i" })
  println(joinedToString)

  println("------------------------")

  // 函数引用也可以用于高阶函数调用：
  val product = items.fold(1, Int::times)
  println(product)
}