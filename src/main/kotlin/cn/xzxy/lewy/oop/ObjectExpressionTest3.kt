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
fun main() {
    var i = 100

    // 对象表达式比java匿名内部类的优点是：
    // Kotlin对象表达式中的代码是可以访问到外层的变量，并且外层变量无需声明为final
    val myObject = object {
        fun method() {
            i++
        }
    }

    myObject.method()
    println(i)
}