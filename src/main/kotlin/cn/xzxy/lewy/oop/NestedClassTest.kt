package cn.xzxy.lewy.oop

/**
 * 嵌套类：
 * 嵌套类不能访问外部类的其他成员，只能访问其他的嵌套类（因为都是静态的）
 */
class OuterClass {

  private val str: String = "hello world"

  class NestedClass {
    fun nestedMethod() = "welcome"
    // fun nestedMethod() = this@OuterClass.str // 报错，因为NestedClass类似静态内部类，无法访问非静态的属性
  }

  class NestedClass2 {
    fun nestedMethod2() = NestedClass() // 由于嵌套类都是静态的，所以可以相互访问
  }
}

fun main() {
  println(OuterClass.NestedClass().nestedMethod())
}