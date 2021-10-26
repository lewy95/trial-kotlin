package cn.xzxy.lewy.garmmar

class TPersonApply(val name: String, var age: Int = 10, var location: String) {

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
   * apply 与 run 相似，不同点在于
   * run 的返回值是最后一行，apply 的返回值是传入的对象
   * 因为 apply 方法常用于初始化时对对象属性进行赋值
   */
  val p = TPersonApply("Muller", 30, "Munich").apply {
    age = 20                       // 和 this.age = 20 或者 adam.age = 20 一样
    location = "London"
    moveTo("Pairs")
    incrementAge()
  }
  println(p.location)
}

