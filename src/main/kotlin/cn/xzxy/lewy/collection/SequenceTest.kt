package cn.xzxy.lewy.collection

/**
 * 序列 sequence
 */
fun generateSeq() {
  // 法一：
  // val numbersSequence = sequenceOf("four", "three", "two", "one")
  // println(numbersSequence.forEach { println(it) })

  // 法二：
  // val numbers = listOf("one", "two", "three", "four")
  // val numbersSequence2 = numbers.asSequence()
  // println(numbersSequence2.forEach { println(it) })

  // 法三：该函数作为参数调用 generateSequence()，
  // 第一个元素指定为显式值或函数调用的结果，当提供的函数返回 null 时，序列生成停止
  // 创建序列默认都是无限的
  val oddNumbers = generateSequence(1) { it + 2 } // `it` 是上一个元素
  println(oddNumbers.take(5).toList())
  //println(oddNumbers.count()) // 报错：此序列是无限的
  // 创建有限序列
  val oddNumbersLessThan10 = generateSequence(1) { if (it + 2 < 10) it + 2 else null }
  println(oddNumbersLessThan10.count())

  // 法四：由组块：有一个函数可以逐个或按任意大小的组块生成序列元素
  // 将一个元素返回给序列使用者，并暂停 sequence() 的执行，直到使用者请求下一个元素
  val oddNumbers2 = sequence {
    yield(1)
    yieldAll(listOf(3, 5))
    yieldAll(generateSequence(7) { it + 2 })
  }
  println(oddNumbers2)
}

fun caseSeq() {
  val words = "The quick brown fox jumps over the lazy dog".split(" ")
  val lengthsList = words.filter { println("filter: $it"); it.length > 3 }
    .map { println("length: ${it.length}"); it.length }
    .take(4)

  println("Lengths of first 4 words longer than 3 chars:")
  println(lengthsList)
}

fun caseSeq2() {
  val words = "The quick brown fox jumps over the lazy dog".split(" ")
  // 将列表转换为序列
  val wordsSequence = words.asSequence()

  val lengthsSequence = wordsSequence.filter { println("filter: $it"); it.length > 3 }
    .map { println("length: ${it.length}"); it.length }
    .take(4)

  println("Lengths of first 4 words longer than 3 chars")
  // 末端操作：以列表形式获取结果。
  println(lengthsSequence.toList())
}

fun caseSeq3() {
  val sequence = sequenceOf(1, 2, 3, 4)
  val result = sequence
    .map { i ->
      println("Map $i")
      i * 2
    }
    .filter { i ->
      println("Filter $i")
      i % 3 == 0
    }
  println(result.first()) // 只取集合的第一个元素
}

fun main() {
  generateSeq()

  caseSeq()
  caseSeq2()

  caseSeq3()
}

