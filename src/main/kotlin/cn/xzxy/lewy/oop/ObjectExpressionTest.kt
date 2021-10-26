package cn.xzxy.lewy.oop

/**
 * 对象表达式 ==> 主要解决java中匿名内部类的一些问题
 *
 * 关于匿名内部类：
 * 1. 一定是实现了某个接口或者实现了某个父类；
 * 2. Java运行时会将该匿名内部类当作它所实现的接口或是继承的父类来看待；
 * 3. 匿名内部类没有名称；
 *
 * 对象表达式的格式：
 * object [: 若干个父类型，中间用逗号分隔]
 */
interface TestInterface {
  fun testPrint(i: Int)
}

abstract class TestAbstractClass {
  abstract val age: Int

  abstract fun printAbstractClassInfo()
}

fun main() {
  // 情况一：对象表达式实现一个接口 / 继承一个父类
  val myObj = object : TestInterface {
    override fun testPrint(i: Int) {
      println("i is $i")
    }
  }
  myObj.testPrint(100)

  println("==================")
  // 情况二：对象表达式实现多个接口 / 继承多个父类，不同于java，java只能是一个
  val myObj2 = object : TestInterface, TestAbstractClass() {
    override fun testPrint(i: Int) {
      println("i is $i")
    }

    override val age: Int
      get() = 80

    override fun printAbstractClassInfo() {
      println("printAbstractClassInfo invoked")
    }
  }

  println(myObj2.age)
  myObj2.testPrint(99)
  myObj2.printAbstractClassInfo()

  println("==================")
  // 情况三：object表达式没有实现任何接口和实现任何类，这一点和java不一样
  val myObj3 = object {
    init {
      println("初始化块执行")
    }

    var myProperty = "oo"
    fun myMethod() = "myMethod"
  }

  println(myObj3.myProperty)
  println(myObj3.myMethod())
}