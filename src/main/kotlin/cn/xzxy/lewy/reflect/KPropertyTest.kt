package cn.xzxy.lewy.reflect

const val name = "yy"

class Person {
  val name = "mm"
}

class Animal {
  var name = "zz"
}

fun main() {
  val property = ::name
  println(property.get())
  println(property.call())
  println("============================")

  val property2 = Person::name
  val person = Person()
  println(property2.get(person))
  println("============================")

  val property3 = Animal::name
  val animal = Animal()
  println(property3.get(animal))
  property3.set(animal, "uu")
  println(property3.call(animal))
}
