package cn.xzxy.lewy.function

/**
 * 函数式编程，真正的逻辑由传入的函数来决定
 */
fun calcPro(a: Int, b: Int, calculate: (Int, Int) -> Int): Int {
  return calculate(a, b)
}

// 案例：根据某些依据过滤字符串
// 要求：lambda + 扩展类
fun String.filter(predicate: (Char) -> Boolean): String {
  // 函数式编程，真正的操作由 predicate 决定
  val stringBuffer = StringBuffer()
  for (index in 0 until length) {
    val element = get(index)
    if (predicate(element)) {
      stringBuffer.append(element)
    }
  }
  return stringBuffer.toString()
}

fun main() {
  println(calcPro(2, 3) { x, y -> x + y })
  println(calcPro(2, 3) { x, y -> x - y })
  println(calcPro(2, 3) { x, y -> x * y })

  println("-----------------------------------")

  val str = "ymyytly69zlyjsyly"
  println(str.filter { it.isLetter() }) // 去除数字
}