package cn.xzxy.lewy.oop

/**
 * 内部类
 *
 * 关于内部类和嵌套类的区别和联系：
 * 1. 嵌套类：对应于java的静态内部类，只要在一个类的内部定义了另外一个类，那么这个类就叫做嵌套类；
 * 2. 内部类：对应于java的非静态内部类，使用inner关键字在一个类的内部所定义的另外一个类就是内部类；
 */
class OuterClass2 {

  private val str: String = "hello world"

  // 内部类必须要加上 inner 关键字，而嵌套类不用
  inner class InnerClass {
    // kotlin访问外部类中属性的方式
    fun nestedMethod() = this@OuterClass2.str
  }
}

fun main() {
  // 内部类和嵌套类的调用方式也不一样
  // println(OuterClass.NestedClass().nestedMethod()) // 由于类似静态内部类，直接用"类名."的方式调用
  println(OuterClass2().InnerClass().nestedMethod())
}