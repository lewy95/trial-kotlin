package cn.xzxy.lewy.function

/**
 * 高阶函数 闭包
 * 闭包的概念：闭包就是能够读取其他函数内部变量的函数
 */
fun main() {
  var sum = ""
  val strings = arrayOf("ym", "yy", "sy")
  strings.filter { it.startsWith("y") }.forEach {
    // kotlin的lambda表达式中允许外层的变量
    // 所以这个地方就是一个闭包
    sum += it
  }
  println(sum)
}