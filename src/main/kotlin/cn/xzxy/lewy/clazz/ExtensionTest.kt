package cn.xzxy.lewy.clazz

/**
 * 扩展机制：可以有效规避类的修改，不仅适用于类和伴生对象
 * 注意点：
 * 1. 扩展本身并不真正插入到类中；
 * 2. 扩展函数的解析是静态分发的，而不是动态的，即不支持多态，调用只取决于对象的声明类型；
 * 3. 调用是由对象声明类型所决定的，而不是由对象的实际类型决定；
 * 4. 扩展的作用域：
 *    1）扩展函数所定义在的类实例叫做分发接受者；
 *    2）扩展函数所扩展的那个类叫做扩展接受者；
 *    3）当以上两个名字出现冲突时，扩展接收者的优先级最高；
 */
class ExtensionTest {

  fun add(a: Int, b: Int) = a + b

  fun substract(a: Int, b: Int) = a - b
}

// 这个方法称为ExtensionTest类的扩展方法，但并没有真正插入到这个类里面
// 扩展方法可以存在于类体中也可以存在于外层
fun ExtensionTest.multiply(a: Int, b: Int) = a * b

fun main() {
  val extensionTest = ExtensionTest()

  println(extensionTest.add(1, 2))
  println(extensionTest.substract(1, 2))
  println(extensionTest.multiply(1, 2))
}