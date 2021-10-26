package cn.xzxy.lewy.garmmar

fun testReturn1() {
  listOf(1, 2, 3, 4, 5).forEach {
    if (it == 3) return // 非局部直接返回到 testReturn1() 的调用者
    print(it)
  }
  println("this point is unreachable")
}

fun testReturn2() {
  listOf(1, 2, 3, 4, 5).forEach lit@{
    if (it == 3) return@lit // 局部返回到该 lambda 表达式的调用者，即 forEach 循环
    print(it)
  }
  println(" done with explicit label")
}

// testReturn3 和 testReturn2 效果是一样的
// testReturn2 是显示声明标签的方式
// testReturn3 是隐式声明标签的方式
fun testReturn3() {
  listOf(1, 2, 3, 4, 5).forEach {
    if (it == 3) return@forEach // 局部返回到该 lambda 表达式的调用者，即 forEach 循环
    print(it)
  }
  println(" done with implicit label")
}

fun testReturn4() {
  listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
    if (value == 3) return  // 局部返回到匿名函数的调用者，即 forEach 循环
    print(value)
  })
  println(" done with anonymous function")
}

fun testReturn5() {
  run loop@{
    listOf(1, 2, 3, 4, 5).forEach {
      if (it == 3) return@loop // 从传入 run 的 lambda 表达式非局部返回
      print(it)
    }
  }
  println(" done with nested loop")
}

fun main() {
  testReturn1()
  println()
  println("========")
  testReturn2()
  println("========")
  testReturn3()
  println("========")
  testReturn4()
  println("========")
  testReturn5()
}