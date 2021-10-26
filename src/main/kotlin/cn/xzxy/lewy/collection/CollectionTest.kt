package cn.xzxy.lewy.collection

/**
 * 集合类：分为可变和不可变的
 */
fun basicOperator() {
  // 集合聚合操作
  val numbers = listOf("one", "two", "three", "four")
  numbers.filter { it.length > 3 }  // `numbers` 没有任何改变，结果丢失
  println("numbers are still $numbers")
  val longerThan3 = numbers.filter { it.length > 3 } // 结果存储在 `longerThan3` 中
  println("numbers longer than 3 chars are $longerThan3")
  // -----------------------------

  // 集合操作指定目标对象
  // 对于目标是一个可变集合，该函数将其结果项附加到该可变对象中，而不是在新对象中返回它们
  // 对于执行带有目标的操作，有单独的函数，其名称中带有 To 后缀，例如，用 filterTo() 代替 filter()
  val filterResults = mutableListOf<String>()  // 目标对象
  numbers.filterTo(filterResults) { it.length > 3 }
  numbers.filterIndexedTo(filterResults) { index, _ -> index == 0 }
  println(filterResults) // 包含两个操作的结果

  // 将数字直接过滤到新的哈希集中，
  // 从而消除结果中的重复项
  val result = numbers.mapTo(HashSet()) { it.length }
  println("distinct item lengths are $result")
}

fun writeSortOperator() {
  val numbers = mutableListOf("one", "two", "three", "four")
  //  sorted() 创建一个新集合，该集合包含按排序顺序相同的元素
  val sortedNumbers = numbers.sorted()
  println(numbers == sortedNumbers)  // false
  // 对可变集合进行排序，不会创建新的集合
  numbers.sort()
  println(numbers == sortedNumbers)  // true
}

fun main() {
  queryClass()
  basicOperator()
  writeSortOperator()
}

fun queryClass() {
  // 创建空集合的方式
  val emptyList = listOf<Int>()
  val emptyList2 = emptyList<Int>()
  val emptySet = setOf<Int>()
  val emptySet2 = emptySet<Int>()
  val emptyMap = mapOf<Int, Int>()
  val emptyMap2 = emptyMap<Int, Int>()

  val initList = listOf(1)
  val initSet = setOf(2)
  val initMap = mapOf(1 to 1)

  val list = listOf(1, 2)
  val set = setOf(1, 2)
  val map = mapOf(1 to 1, 2 to 2)

  println("空元素只读集合")
  println(emptyList.javaClass) // kotlin.collections.EmptyList
  println(emptyList2.javaClass) // kotlin.collections.EmptyList
  println(emptySet.javaClass) // kotlin.collections.EmptySet
  println(emptySet2.javaClass) // kotlin.collections.EmptySet
  println(emptyMap.javaClass) // kotlin.collections.EmptyMap
  println(emptyMap2.javaClass) // kotlin.collections.EmptyMap

  println("单元素只读集合")
  println(initList.javaClass) // java.util.Collections$SingletonList
  println(initSet.javaClass) // java.util.Collections$SingletonSet
  println(initMap.javaClass) // java.util.Collections$SingletonMap

  println("多元素只读集合")
  println(list.javaClass) // java.util.Arrays$ArrayList
  println(set.javaClass) // java.util.LinkedHashSet
  println(map.javaClass) // java.util.LinkedHashMap

  println("-----------------------------------------------------------------")

  val emptyMutableList = mutableListOf<Int>()
  val emptyMutableSet = mutableSetOf<Int>()
  val emptyMutableMap = mutableMapOf<Int, Int>()

  val initMutableList = mutableListOf(1)
  val initMutableSet = mutableSetOf(2)
  val initMutableMap = mutableMapOf(1 to 1)


  val mutableList = mutableListOf(1, 2)
  val mutableSet = mutableSetOf(1, 2)
  val mutableMap = mutableMapOf(1 to 1, 2 to 2)

  println("空元素可变集合")
  println(emptyMutableList.javaClass) // java.util.ArrayList
  println(emptyMutableSet.javaClass) // java.util.LinkedHashSet
  println(emptyMutableMap.javaClass) // java.util.LinkedHashMap

  println("单元素可变集合")
  println(initMutableList.javaClass) // java.util.ArrayList
  println(initMutableSet.javaClass) // java.util.LinkedHashSet
  println(initMutableMap.javaClass) // java.util.LinkedHashMap

  println("多元素可变集合")
  println(mutableList.javaClass) // java.util.ArrayList
  println(mutableSet.javaClass) // java.util.LinkedHashSet
  println(mutableMap.javaClass) // java.util.LinkedHashMap
}
