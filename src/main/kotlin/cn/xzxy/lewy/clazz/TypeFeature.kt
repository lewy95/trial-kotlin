package cn.xzxy.lewy.clazz

/**
 * Kotlin 类型的特点：
 * 1. 支持类似推断
 * 2. 不确定类型，如 Int?
 * 3. 类型的转换：直接用toXXX的方法即可，区别与java的转换，kotlin更方便
 * 3. 手动类型判别，通过 is 关键字
 */
/**
 * Any 是 Kotlin 中类型的最顶层类，类似java中的Object，但不能相提并论
 */
fun main() {
  println(isType("915"))

  val uncertainReturn = uncertainType(4, 2)
  println("uncertainReturn: $uncertainReturn")

  transferType()
  strConvert2Int("915")
}

fun isType(str: Any): String? {
  if (str is String) str.toUpperCase()

  return null
}

// 测试不确定类型，如 Int? 表示返回值可以是 Int 或 null
fun uncertainType(a: Int, b: Int): Int? {

  val num: Int?
  try {
    num = a / b
  } catch (e: Exception) {
    e.printStackTrace()
    return null // 如果为返回值为 Int，则这行报错
  }
  return num
}

// 类型转换
fun transferType() {
  // 整形转其他
  val aaa = 666
  println(aaa.toDouble()) // 123.0
  println(aaa.toFloat())  // 123.0
  println(aaa.toString())

  // 字符串转其他
  val str = "915"
  println(str.toInt())
}

// 扩展：字符串转整形的工具方法
// 使用时需要对该数进行判空，因为返回类型是Int?，可能唯恐
fun strConvert2Int(str: String): Int? {
  return try {
    str.toInt()
  } catch (e: Exception) {
    null
  }
}