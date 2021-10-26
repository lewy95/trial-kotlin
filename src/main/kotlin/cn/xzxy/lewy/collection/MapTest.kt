package cn.xzxy.lewy.collection

/**
 * map 默认实现为 linkedHashMap 可以保证插入时的顺序
 * 1. map不是collection的接口，这一点和java一样；
 * 2. 无论键值对的顺序如何，包含相同键值对的两个 Map 是相等的;
 * 3. 构造map时，"key1" to 1形式中 to 符号创建了一个短时存活的 Pair 对象，
 *    因此建议仅在性能不重要时才使用它，避免占用过多内存.
 *    推荐使用 apply 方法，但 apply 只适用于 mutableMap；
 * 4. 另一种实现 HashMap，不保证顺序，但内存占用较小
 */
fun main() {

  // 不可变map，没有 put / remove 方法
  val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)
  // 关于map的构造方式，to符号会占用额外内存，推荐使用apply方法
  // 但可以看到 apply 的方式只适用于 mutableMapOf
  //val numbersMapPro = mutableMapOf<String, String>().apply {
  //    this["one"] = "1"; this["two"] = "2"
  //}

  println("All keys: ${numbersMap.keys}")
  println("All values: ${numbersMap.values}")
  // 判断key在map中的方式
  if ("key2" in numbersMap) println("Value by key \"key2\": ${numbersMap["key2"]}")
  // 判断value在map中的方式
  if (1 in numbersMap.values) println("The value 1 is in the map")
  if (numbersMap.containsValue(1)) println("The value 1 is in the map") // 同上

  // 遍历map
  // 法一：
  //numbersMap.forEach{
  //    println(it.key.toUpperCase())
  //    println(it.value.minus(1))
  //}
  // 法二：
  for ((key, value) in numbersMap) println("key:$key value:$value")

  // 无论键值对的顺序如何，包含相同键值对的两个 Map 是相等的
  // 必须要key和value都相同才行
  val numbersMap2 = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)
  val anotherMap2 = mapOf("key2" to 2, "key1" to 1, "key4" to 1, "key3" to 3)
  println("The maps are equal: ${numbersMap2 == anotherMap2}")

  println("*********************************************************")

  // 可变map，支持新增和删除
  val numbersMap3 = mutableMapOf("one" to 1, "two" to 2)
  numbersMap3["three"] = 3 // 新增或修改，本质是put(key, value)
  numbersMap3["one"] = 11
  numbersMap3.remove("two") // 删除一个k/v

  println(numbersMap3)

}