package cn.xzxy.lewy.collection

/**
 * 迭代器：对象可按顺序提供对元素的访问权限，而不会暴露集合的底层结构
 * 特别当需要逐个处理集合的所有元素（例如打印值或对其进行类似更新）时，迭代器非常有用。
 */
// 基本迭代器
fun iterable1() {
    val numbers = listOf("one", "two", "three", "four")
    // 获得迭代器
    val numbersIterator = numbers.iterator()
    while (numbersIterator.hasNext()) {
        println(numbersIterator.next())
    }
}

// 隐式转换
fun iterable2() {
    val numbers = listOf("one", "two", "three", "four")
    for (item in numbers) {
        println(item)
    }
}

// foreach
fun iterable3() {
    val numbers = listOf("one", "two", "three", "four")
    numbers.forEach {
        println(it)
    }
}

// 可变迭代器
fun mutableIterator() {
    val numbers = mutableListOf("one", "two", "three", "four")
    val mutableIterator = numbers.iterator()

    mutableIterator.next()
    mutableIterator.remove()
    println("After removal: $numbers")
}

fun main() {

    iterable1()
    println("-----------")
    iterable2()
    println("-----------")
    iterable3()
    println("-----------")
    mutableIterator()

}