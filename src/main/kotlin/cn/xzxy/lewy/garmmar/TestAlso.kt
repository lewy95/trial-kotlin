package cn.xzxy.lewy.garmmar

class TPersonAlso(val name: String, var age: Int = 10, var location: String) {

  fun moveTo(newPlace: String) {
    println("now in $newPlace")
  }

  fun incrementAge(): Int {
    println("one year older")
    return age + 1
  }
}

fun main() {
  /**
   * also 和 let 相似，区别在于
   * let 的返回值是最后一行，而 also 的返回值是传入的对象
   */
  TPersonAlso("Muller", 30, "Munich").also {
    println(it)
    it.moveTo("London")
    it.incrementAge()
    println(it)
  }

}