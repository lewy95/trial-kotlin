package cn.xzxy.lewy.generic

/**
 * 泛型函数
 */
fun <T> getValue(item: T): T {
  return item
}

fun main() {
  val item = getValue(3)
  println(item)

  val item2 = getValue("oo")
  println(item2)
}