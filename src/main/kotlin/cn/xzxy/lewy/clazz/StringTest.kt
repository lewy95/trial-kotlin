package cn.xzxy.lewy.clazz

/**
 * 字符串操作
 */
fun main() {
  testJoinToString()
}

fun testJoinToString() {
  val numbers = listOf("one", "two", "three", "four")

  println(numbers)
  println(numbers.joinToString())

  val listString = StringBuffer("The list of numbers: ")
  numbers.joinTo(listString)
  println(listString)

  // 指定分隔符/前缀/后缀
  println(
    numbers.joinToString(
      separator = " | ",
      prefix = "start: ",
      postfix = ": end"
    )
  )
  // start: one | two | three | four: end

  // 对于较大的集合，可能需要指定 limit ——将包含在结果中元素的数量
  // 如果集合大小超出 limit，所有其他元素将被 truncated 参数的单个值替换
  val numbers2 = (1..100).toList()
  println(numbers2.joinToString(separator = " * ", limit = 10, truncated = "<...>"))
  // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, <...>

  // 自定义元素本身的表示形式
  println(numbers.joinToString { "Element: ${it.toUpperCase()}" })
  println(numbers.joinToString { element -> element.toLowerCase().take(2) })
}