package cn.xzxy.lewy.garmmar

/**
 * 案例：return与标签的说明（在非循环中）
 */

data class TPersonReturn(val name: String, var age: Int = 10, var location: String)

fun main() {
  TPersonReturn("Leon", 19, "Munich").apply {
    // 如果符合，直接返回apply，不再执行后面的操作，反之继续往后走
    // 因此return不管带不带标签，都可理解为 break
    if (age > 20) return@apply
    println("older than 20")

    if (!name.startsWith("A")) return@apply
    println("not named 'L'")
  }
}