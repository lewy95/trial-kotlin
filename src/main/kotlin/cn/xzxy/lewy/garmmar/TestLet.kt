package cn.xzxy.lewy.garmmar

/**
 * let扩展函数的实际上是一个作用域函数，let函数用于定义一个变量在一个特定的作用域范围内
 * let函数另一个作用就是可以避免写一些判断null的操作
 */
class TPersonLet(val name: String, private val age: Int = 10, val location: String) {

  fun moveTo(newPlace: String) {
    println("now in $newPlace")
  }

  fun incrementAge(): Int {
    println("one year older")
    return age + 1
  }
}

fun main() {
  // 定义一个变量在一个特定的作用域范围内
  TPersonLet("Alice", 20, "Amsterdam").let {
    println(it)
    it.moveTo("London")
    it.incrementAge()
    println(it)
  }

  // 另一种用途 判断object为null的操作
  // obj?.let{ //表示object不为null的条件下，才会去执行let函数体
  //    it.doSth()
  // }

}


