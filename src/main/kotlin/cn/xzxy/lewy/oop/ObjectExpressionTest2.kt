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
class MyClass9 {

  // 匿名对象只能在局部变量范围内或是被private修饰的成员变量范围内才能被识别出其真正的类型
  // 如果将匿名对象当作一个public/internal方法的返回类型或是public属性的类型，那么该方法或是属性的真正类型
  // 就是该匿名对象所声明的父类型，如果没有声明任何父类型，那么其类型就是Any，
  // 在这种情况下，匿名对象中声明的任何成员都是无法被访问的
  private var myObject = object {
    fun output() {
      println("output invoked")
    }
  }

  fun myTest() {
    println(myObject.javaClass)
    myObject.output() // public var myObject = object { 情况下output方法是没有的
  }
}

fun main() {
  // object表达式没有实现任何接口和实现任何类，这一点和java不一样
  val myClass = MyClass9()
  myClass.myTest()
}