package cn.xzxy.lewy.garmmar

/**
 * when 语法
 */
fun main() {
  println(statementWhen1("A"))
  println(statementWhen2(6))
}

fun statementWhen1(string: String): String {
  return when (string) {
    "A" -> "AAA"
    "B" -> "BBB"
    "C" -> "CCC"
    else -> "???"
  }
}

fun statementWhen2(x: Int): Int {
  return when (x) {
    1 -> {
      10
    }
    2 -> {
      20
    }
    3, 4, 5 -> {
      30
    }
    in 6..10 -> {
      40
    }
    else -> {
      50
    }
  }
}