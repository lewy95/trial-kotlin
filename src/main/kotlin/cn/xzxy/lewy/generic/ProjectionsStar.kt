package cn.xzxy.lewy.generic

/**
 * 星投影
 * Kotlin 为此提供了所谓的星投影语法：
 * 1. 对于 Foo <out T : TUpper>，其中 T 是一个具有上界 TUpper 的协变类型参数，
 * Foo <*> 等价于 Foo <out TUpper>，这意味着当 T 未知时，可以安全地从 Foo <*> 读取 TUpper 的值；
 * 2. 对于 Foo <in T>，其中 T 是一个逆变类型参数，Foo <*> 等价于 Foo <in Nothing>，这意味着当 T 未知时，无法向其中写入任何值；
 * 3. 对于 Foo <T : TUpper>，其中 T 是一个具有上界 TUpper 的不型变类型参数，Foo<*> 对于读取值时等价于 Foo<out TUpper>，而对于写值时等价于 Foo<in Nothing>；
 */
class Star<out T> {

}

class Star2<in T> {
  fun setValue(t: T) {

  }
}

class Star3<T>(private var t: T) {
  fun setValue(t: T) {

  }

  fun getValue(): T {
    return this.t
  }
}

fun main() {
  val star: Star<Number> = Star<Int>()
  val star2: Star<*> = star
  val star3: Star2<Int> = Star2<Number>()
  val star4: Star2<*> = star3

  // star4.setValue(9) // 编译错误，因为Star2<in T>，按照第二种，即Star2<in Nothing>，不能写入任何值
  // star3.setValue(9) // 编译成功

  val star5: Star3<String> =
    Star3<String>("oo")
  val star6: Star3<*> = star5

  star6.getValue() // 读值没问题
  // star6.setValue(9) // 编译错误，写值时等于Star3<in Nothing>，不能写入任何值

  // 更常见的：
  val ma: MutableList<*> = mutableListOf<String>("ym", "yy", "zly")
  // ma.add(3, "tly") // 编译错误，写值时等于MutableList<in Nothing>，不能写入任何值
  println(ma[2]) // 读值没问题
}