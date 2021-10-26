package cn.xzxy.lewy.garmmar

class TPersonWith(val name: String, private val age: Int = 10, val location: String) {

  fun moveTo(newPlace: String) {
    println("now in $newPlace")
  }

  fun incrementAge(): Int {
    println("one year older")
    return age + 1
  }
}

fun main() {
  val person = TPersonWith("Alice", 20, "Amsterdam")

  with(person) {
    val incrementAge = incrementAge()
    println("name is $name, come from $location, next age is $incrementAge")
    moveTo("Munich")
  }
}