package cn.xzxy.lewy.oop

import java.util.*

/**
 * 属性委托之Map委托
 *
 * 将属性存储到map中
 * 一种常见的应用场景是将属性值存储到mp中，这通常出现在JSON解决或是一些动态行为
 * 在这种情况下，可以将map实例作为委托，作为类中属性的委托
 */
class MapDelegation(map: Map<String, Any?>) {
    val name: String by map
    val address: String by map
    val age: Int by map
    val birthday: Date by map
}

class MapDelegation2(map: MutableMap<String, Any?>) {
    var address: String by map
}

fun main() {
    val mapDelegation = MapDelegation(mapOf(
        "name" to "muller",
        "address" to "shanghai",
        "age" to 30,
        "birthday" to Date()
    ))
    println(mapDelegation.name)
    println(mapDelegation.address)
    println(mapDelegation.age)
    println(mapDelegation.birthday)

    println("----------")

    val nm: MutableMap<String, Any?> = mutableMapOf(
        "address" to "shanghai"
    )

    val mapDelegation2 = MapDelegation2(nm)
    println(nm["address"])

    println("----------")

    mapDelegation2.address = "beijing"
    println(mapDelegation2.address)


}