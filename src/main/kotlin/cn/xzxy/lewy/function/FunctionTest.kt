package cn.xzxy.lewy.function

/**
 * 函数调用
 * 注意：在kotlin中调用java方法时不能使用具名参数，因为java字节码并不总是保留方法参数名信息
 */
fun defaultArgsTest(a: Int = 1, b: Int = 2) = println(a - b)

fun defaultArgsTest2(a: Int = 3, b: Int) = println(a - b)

fun defaultArgsTest3(a: Int, b: Int = 3, c: Int = 5, d: Int) = println(a - b)


fun lambdaArgsTest(a: Int = 1, b: Int = 2, compute: (x: Int, y: Int) -> Unit) {
  compute(a, b)
}

// 可变参数
// kotlin只允许拥有一个可变参数vararg，通常作为最后一个参数
// 如果vararg不是最后一个参数，那么vararg之后参数必须通过具名参数来调用
fun varargTest(i: Int, vararg strings: String) {
  println(i)
  println(strings.javaClass)
  strings.forEach { println(it) }
}

fun <T> varargTest2(vararg element: T): List<T> {
  val result = ArrayList<T>()
  element.forEach { result.add(it) }
  return result
}

fun main() {
  // 对于具有默认参数的函数调用，可以省略参数
  defaultArgsTest() // -1
  defaultArgsTest(3) // a=3 res=1
  defaultArgsTest(3, 4) // -1
  // 使用具名参数赋值，特别是当a用默认值，需要给b赋值时，必须指定名称
  defaultArgsTest(b = 5) // -4
  // 若一个函数的一个默认参数位于其他无默认值参数之前，如defaultArgsTest2
  // 那么默认值只能通过在调用函数时使用具名参数
  //defaultArgsTest2(2) // 编译失败，a=2，但b没有赋值
  defaultArgsTest2(b = 2)

  // defaultArgsTest3(1, b = 2, 5); 编译失败，所有的位置参数都应该位于具名参数之前
  defaultArgsTest3(1, 2, 3, d = 4) // 编译成功

  // ------------------------------------
  // 默认参数重写测试
  println(A().method(1))
  println(B().method(2))

  // -------------------------------------
  // 对于lambda表达式的函数调用
  // 使用两个参数
  lambdaArgsTest(1, 2) { x, y -> println(x - y) } // 法一
  lambdaArgsTest(1, 2, ::defaultArgsTest) // 法二

  // 使用一个参数
  lambdaArgsTest(1) { x, y -> println(x - y) }
  lambdaArgsTest(b = 6) { x, y -> println(x - y) }
  // 不使用默认参数
  lambdaArgsTest { x, y -> println(x - y) }
  // 注意：对于lambdaArgsTest(a: Int = 1, b: Int = 2, compute: (x:Int, y:Int) -> Unit)
  // 有默认参数的在无默认参数之间，但这个默认参数是一个lambda表达式，并且调用时在圆括号之外
  // 此时就不需要指定lambda表达式的具名参数

  // -------------------------------------
  // 可变参数函数的调用
  // *arrayOf 表示分散运算符，将数组打散为string
  varargTest(3, strings = arrayOf("a", "b", "c"))

  println(varargTest2("a", "b", "c"))
  val elements = arrayOf("d", "e", "f")
  println(varargTest2("g", "h", *elements))
}

/**
 * 关于具有默认参数的函数的继承：
 * 1. 对于重写的方法来说，子类所拥有的重写方法会使用与父类相同的默认参数值。
 * 2. 在重写一个拥有默认参数值的方法时，方法签名中必须要将默认参数值省略掉。
 */
open class A {
  open fun method(a: Int, b: Int = 4) = a + b
}

class B : A() {
  // 这边如果 b:Int=4，则会报错
  override fun method(a: Int, b: Int) = a + b
}