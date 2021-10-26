package cn.xzxy.lewy.function

/**
 * 函数的其他内容：
 * 1. 中缀表达式；
 * 2. 内联函数；
 */
class InfixTest(private var a: Int) {
    infix fun add(b: Int) = this.a + b
}

inline fun myCal(a: Int, b: Int) = a + b

fun main() {
    val infixTest = InfixTest(2)
    // 以下两种方式等价
    println(infixTest.add(2))
    println(infixTest add 2)

    // 调用内联函数
    println(myCal(1,2))
}