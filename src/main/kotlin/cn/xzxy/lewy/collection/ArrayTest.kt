package cn.xzxy.lewy.collection

/**
 * 数组，是可变的
 */
fun testArray() {
  // intArray int类型数组
  val intArray = intArrayOf(9, 2, 3, 4, 5)
  // 数组是可变的
  intArray[1] = 8 // 修改数组元素，本质是一个set(index, value)方法
  println(intArray[2]) // 获取数组元素，本质是一个get(index)方法

  // 根据lambda表达式创建
  // 第一个参数：长度
  // 第二个参数：lambda表达式
  val strArray = Array(3) { "miss you $it" }
  strArray.forEach { println(it) }

  println("-----------------------")
  // 遍历方式
  intArray.forEach(System.out::println)
  println("-----------------------")
  // 以元组形式遍历
  for ((index, value) in intArray.withIndex()) {
    println("array[$index] == $value")
  }

  println("*****************")
  // 定义一个初始元素都为null的数组
  val an = arrayOfNulls<String>(3)
  an.forEach { println(it) }

}

fun main() {
  testArray()
}
