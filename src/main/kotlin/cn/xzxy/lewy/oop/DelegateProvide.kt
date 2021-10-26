package cn.xzxy.lewy.oop

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * 提供委托
 */
class PeopleTest {
  val name: String by PeopleLauncher()
  val address: String by PeopleLauncher()
}

class PropertyDelegate : ReadOnlyProperty<PeopleTest, String> {
  override fun getValue(thisRef: PeopleTest, property: KProperty<*>): String {
    return "hello world"
  }
}

class PeopleLauncher {
  // provideDelegate 方法名不能改
  operator fun provideDelegate(thisRef: PeopleTest, property: KProperty<*>): ReadOnlyProperty<PeopleTest, String> {
    println("welcome")

    when (property.name) {
      "name", "address" -> return PropertyDelegate()
      else -> throw Exception("not valid name")
    }
  }
}

fun main() {
  val people = PeopleTest()
  println(people.name)
  println(people.address)
}