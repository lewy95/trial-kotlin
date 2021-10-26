package cn.xzxy.lewy.collection

/**
 * set 默认实现 LinkedHashSet 因此可以维护顺序
 * 1. 存储唯一的元素；它们的顺序通常是未定义的;
 * 2. null 元素也是唯一的：一个 Set 只能包含一个 null;
 * 3. 当两个 set 具有相同的大小并且对于一个 set 中的每个元素都能在另一个 set 中存在相同元素，则两个 set 相等;
 * 4. 除了 LinkedHashSet，也可以以 HashSet 的形式实现，但顺序不保证，好处是使用内存较小
 */
fun testSet() {

  // --可变set------------------------------------------------

  val numbers = setOf(1, 2, 3, 4)
  println("Number of elements: ${numbers.size}")
  if (numbers.contains(1)) println("1 is in the set")

  val numbersBackwards = setOf(4, 3, 2, 1)
  println("The sets are equal: ${numbers == numbersBackwards}")

  // 指定构造
  val myHashSet = mutableSetOf<Int>().apply {
    for (i in 1..100) add(i)
  }
  // myHashSet.forEach { println(it) }
  println("---")
  val random = myHashSet.random()
  println(random) // 随机一个值
  println("---")

  // --不可变set-----------------------------------------------
  val numbers2 = setOf(1, 2, 3, 4)  // LinkedHashSet is the default implementation
  val numbersBackwards2 = setOf(4, 3, 2, 1)

  println(numbers2.first() == numbersBackwards2.first())
  println(numbers2.first() == numbersBackwards2.last())

}

fun main() {
  testSet()

}