package cn.xzxy.lewy.garmmar

class TPersonRun(val name: String, private val age: Int = 10, val location: String) {

  fun moveTo(newPlace: String): Unit {
    println("now in $newPlace")
  }

  fun incrementAge(): Int {
    println("one year older")
    return age + 1
  }
}

fun main() {
  val person = TPersonRun("Alice", 20, "Amsterdam")

  /**
   * run 是 let 和 with 的结合体
   * 既具有 with 简便的写法（不需要写it），也具有 let 可进行对象判空的特性
   */
  person.run {
    val incrementAge = incrementAge()
    println("name is $name, come from $location, next age is $incrementAge")
    moveTo("Paris")
  }

}