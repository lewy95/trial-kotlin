package cn.xzxy.lewy.collection

/**
 * 集合的转换：
 * 1. 映射: mapping
 * 2. 合拢：zip
 * 3. 关联：associate
 * 4. 打平：flatten
 * 5. 过滤：filter
 * 6. 划分：partition
 * 7. 检验：any / none / all
 * 8. 加减：plus / minus
 * 9. 分组：groupBy
 * 10.截取：slice / take / drop / chunked / windowed
 * 11.获取：elementAt / first / last / find / random / contains
 * 12.排序：sort
 * 13.聚合：groupby
 * 14.累加: reduce
 */
fun main(args: Array<String>) {

  // mapping()
  // zip()
  // associate()
  // flatten()
  // filer()
  // partition()
  // check()
  // move()
  // groupBy()
  // reduce()
  // sort()
}

data class Student(
  val id: Int,
  val name: String
)

fun mapping(): Unit {
  val numbers = setOf(1, 2, 3)
  println(numbers.map { "222" })
  println(numbers.mapIndexed { idx, value -> value * idx })
  println("----------------------------")

  // 如果转换在某些元素上产生null值，用mapNotNull从集合中null值
  val numbers2 = setOf(1, 2, 3)
  println(numbers2.mapNotNull { if (it == 2) null else it * 3 })
  println(numbers2.mapIndexedNotNull { idx, value -> if (idx == 0) null else value * idx })
  println("----------------------------")

  // 映射转换时，有两个选择：转换键，使值保持不变，反之亦然
  val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
  println(numbersMap.mapKeys { it.key.toUpperCase() })
  println(numbersMap.mapValues { it.value + it.key.length })
}

fun zip(): Unit {
  // 拉链操作
  val colors = listOf("red", "brown", "grey")
  val animals = listOf("fox", "bear", "wolf")
  println(colors zip animals)

  // 集合的大小不同，则 zip() 的结果为较小集合的大小，结果中不包含较大集合的后续元素
  val twoAnimals = listOf("fox", "bear")
  println(colors.zip(twoAnimals))
  println("---------------------------------------")

  val colors2 = listOf("red", "brown", "grey")
  val animals2 = listOf("fox", "bear", "wolf")

  println(colors2.zip(animals2) { colors2, animals2 -> "The ${animals2.capitalize()} is $colors2" }
  )
  println("---------------------------------------")

  // 反向拉链 unzipping
  val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
  println(numberPairs.unzip())
}

fun associate(): Unit {
  // associateWith 创建一个 map key由原始集合生成
  // key：其原始集合的键，value：通过给定转换函数从中产生值
  val numbers = listOf("one", "two", "three", "four")
  println(numbers.associateWith { it.length })

  // associateBy 创建一个 map value由原始集合生成
  // key：根据接收函数转换 value：原始集合中的键
  // 当Key相同时，只保留后面一个
  println(numbers.associateBy { it.first().toUpperCase() })
  println(numbers.associateBy(
    keySelector = { it.first().toUpperCase() },
    valueTransform = { it.length }
  ))

  // associate 创建一个 map key/value都由原始集合生成
  // associate 会在内存中生产临时的pair对象，可能会影响性能
  val names = listOf("Alice Adams", "Brian Brown", "Clara Campbell")
  println(names.associate { Pair(it.split(" ")[0], it.split(" ")[1]) })
}

fun flatten(): Unit {
  val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
  // flatten 去集合，返回一个外层大的集合，包含所有元素
  val newList = numberSets.flatten()
  println(newList)

  // flatMap 为集中每个元素创建一个集合，最后fatten到同一个集合中
  val list = listOf(1, 2, 3)
  println(list.flatMap { listOf(it, it * 2) })
}

fun filer(): Unit {
  // collection 类 filter
  val numbers = arrayListOf("one", "two", "three", "four")
  numbers.apply {
    println(size)
    numbers.filter { it.startsWith("o") }.forEach { _ -> numbers.remove("one") }
    println(size)
  }


//  val longerThan3 = numbers.filter { it.length > 3 }
//  println(numbers) // [one, two, three, four] 原集合不变
//  println(longerThan3)
//  // map 类 filter
//  val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
//  val filteredMap = numbersMap.filter { (key, value) -> key.endsWith("1") && value > 10 }
//  println(filteredMap)
//
//  // filterIndexed 在过滤中使用元素在集中中的位置
//  // 接收两个参数：元素的索引和元素的值
//  val filteredIdx = numbers.filterIndexed { index, s -> (index != 0) && (s.length < 5) }
//  println(filteredIdx)
//
//  // filterNot 使用否定条件来过滤集合
//  val filteredNot = numbers.filterNot { it.length <= 3 }
//  println(filteredNot) // [three, four] 输出大于3的元素
//
//  // filterIsInstance 返回给定类型的集合元素
//  // 即在一个 List<Any?> 上被调用时，filterIsInstance<T>() 返回一个 List<T>
//  val numbers2: List<Any?> = listOf(null, 1, "two", 3.0, "four")
//  println("All String elements in upper case:")
//  numbers2.filterIsInstance<String>().forEach {
//    println(it.toUpperCase())
//  }
//
//  // filterNotNull 返回所有的非空元素
//  // 即在一个 List<T?> 上被调用时，filterNotNull() 返回一个 List<T: Any>
//  val numbers3 = listOf(null, "one", "two", "", null)
//  println(numbers3.filterNotNull()) // [one, two, ]
}

fun partition(): Unit {

  val numbers = listOf("one", "two", "three", "four")
  // 声明两个集合，第一个存放匹配，第二个存放不匹配
  val (match, rest) = numbers.partition { it.length > 3 }
  println(match) // [three, four]
  println(rest) // [one, two]
}

fun check(): Unit {
  val numbers = listOf("one", "two", "three", "four")

  // 如果至少有一个元素匹配给定谓词
  println(numbers.any { it.endsWith("e") })
  // 如果没有元素与给定谓词匹配
  println(numbers.none { it.endsWith("a") })
  // 如果所有元素都匹配给定谓词
  println(numbers.all { it.endsWith("e") })
  // 注意: 在一个空集合上使用任何有效的谓词去调用 all() 都会返回 true
  // 这种行为在逻辑上被称为 vacuous truth
  println(emptyList<Int>().all { it > 5 })

  // 不带参数
  // any 和 none 用来检查集合是否为空
  val empty = emptyList<String>()

  println(numbers.any()) // 集合中有元素返回true
  println(empty.any())

  println(numbers.none()) // 集合中没有元素返回true
  println(empty.none())
}

fun move(): Unit {
  // Kotlin 中，为集合定义了 plus (+) 和 minus (-) 操作符
  // 它们把一个集合作为第一个操作数；第二个操作数可以是一个元素或者是另一个集合
  // 返回值是一个新的只读集合
  val numbers = mutableListOf("one", "two", "three", "four")
  val plusList = numbers + "five"
  val minusList = numbers - "one"
  val minusList2 = numbers - listOf("three", "four")
  println(plusList) // 包含原始集合和第二个操作数中的元素
  println(minusList) // 含原始集合中的元素，但第二个操作数中的元素除外，移除其在原始集合中的第一次出现
  println(minusList2) // 包含原始集合中的元素，但第二个操作数中的元素除外

  // plusAssign (+= 加并赋值) 和 minusAssign (-=)
  numbers += "six"
  println("after plusAssign: $numbers")
  numbers -= "six"
  println("after minusAssign: $numbers")
}

fun groupBy(): Unit {

  val numbers = listOf("one", "two", "three", "four", "five")

  // groupBy() 使用一个 lambda 函数并返回一个 Map
  // 在此 Map 中，每个键都是 lambda 结果，而对应的值是返回此结果的元素 List
  println(numbers.groupBy {
    it.first().toUpperCase()  // 指定分组键
  })

  // groupBy() 带参数（值转换函数）调用
  // 带有两个 lambda 的 groupBy() 结果 Map 中，
  // 由 keySelector 函数生成的键映射到值转换函数的结果，而不是原始元素
  // 与上面的区别在于，不是值原始元素
  println(numbers.groupBy(
    keySelector = { it.first() }, // 指定分组键
    valueTransform = { it.toUpperCase().take(3) } // 指定value的变换
  ))

  // ---------------------------------------
  // 关于 Grouping
  // 要对元素进行分组，然后一次将操作应用于所有分组，用 groupingBy()，会返回一个 Grouping 类型的实例。
  // 通过 Grouping 实例，可以以一种惰性的方式将操作应用于所有组：
  // 这些分组实际上是刚好在执行操作前构建的，有点类似与 groupBy后的having
  val numbers2 = listOf("one", "two", "three", "four", "five", "six")
  println(numbers2.groupingBy { it.first() }.eachCount())
  // 除了eachCount，还有：
  // fold() 与 reduce() 对每个组分别执行 fold 与 reduce 操作，作为一个单独的集合并返回结果。
  // aggregate() 随后将给定操作应用于每个组中的所有元素并返回结果，这是对 Grouping 执行任何操作的通用方法。当折叠或缩小不够时，可使用它来实现自定义操作。
}

fun sort() {
  val numbers = listOf(1, 3, 2, 5, 4)
  val compareVipExp = Comparator { v1: Int, v2: Int -> v2 - v1 }
  println(numbers.sortedWith(compareVipExp))
}