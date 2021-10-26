package cn.xzxy.lewy.oop

/**
 * 委托：类委托
 */
interface MyInterface {
  fun printInfo()
}

class MyInterfaceImpl(private val str: String) : MyInterface {
  override fun printInfo() {
    println("printing + $str")
  }

}

/**
 * 类委托原理：
 * by关键字后的对象实际上会被存储在类的内部，编译器则会将父接口中的所有方法实现
 * 并且将实现转移给委托对象去进行
 */
class MyClass(myInterface: MyInterface) : MyInterface by myInterface {

}

fun main() {
  val myInterfaceImpl = MyInterfaceImpl("tony")
  MyClass(myInterfaceImpl).printInfo()
}

