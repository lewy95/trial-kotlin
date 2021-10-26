package cn.xzxy.lewy.function

/**
 * 带接受者的函数字面量：
 * Kotlin可以通过指定的接收者对象来调用一个函数字面值
 * 在函数字面值内部，可以调用接收者对象的方法而无需使用任何额外的修饰符
 * 这一点非常类似于扩展函数
 */
fun main() {
  val subtract: Int.(other: Int) -> Int = { other -> this - other }
  println(1.subtract(3))

  // 匿名函数语法可以指定函数字面值的接受者类型
  // 这样，就可以先声明一个带有接收者的函数类型变量，然后再去使用它
  val sum = fun Int.(other: Int): Int = this + other
  println(1.sum(4))

  // 带有接收者类型的函数的非字面值可以作为参数进行传递，前提是需要接受函数的地方有一个接收者类型的参数，反之亦然
  // 比如 String.(Int) -> Boolean 和 （String, Int）-> Boolean
  val myEquals: String.(Int) -> Boolean = { param -> this.toIntOrNull() == param }
  println("777".myEquals(777))

  fun myTest(op: (String, Int) -> Boolean, a: String, b: Int, c: Boolean) = println(op(a, b) == c)
  myTest(myEquals, "200", 200, true)
}