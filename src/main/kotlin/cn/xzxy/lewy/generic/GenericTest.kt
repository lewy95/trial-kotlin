package cn.xzxy.lewy.generic

/**
 * 泛型
 */
class MyGeneric<T>(t: T) {

  var variable: T = t
}

fun main() {
  // 完整的泛型写法
  // val myGeneric : MyGeneric<String> = MyGeneric<String>("oo")

  // 使用类似推断
  val myGeneric = MyGeneric("yy")
  println(myGeneric.variable)
}
