package cn.xzxy.lewy.function

/**
 * 函数：中缀表达式；
 */
class InfixTest(private var a: Int) {
  infix fun add(b: Int) = this.a + b
}

fun main() {
  val infixTest = InfixTest(2)
  // 以下两种方式等价
  println(infixTest.add(2))
  println(infixTest add 2)
}