package cn.xzxy.lewy.garmmar

/**
 * 转义 """ """
 */
fun escape() {
  val s1 = "hello \n oo"
  println(s1)

  val s2 = """hello \n oo"""
  println(s2)
}

fun main() {

  escape()
  itAndThis()
  allAndAny()
}

fun itAndThis() {
  val str = "Hello"
  // this
  str.run {
    println("The receiver string length: $length")
    //println("The receiver string length: ${this.length}") // 和上句效果相同
  }

  // it
  println("The receiver string's length is ${str.length}")
  // println("The receiver string's length is ${str.length}") // 和上句效果相同
}

fun allAndAny() {
  val array = arrayOf("yy", "ym", "ss", "nn", "sy")

  val b1: Boolean = array.all { it.startsWith("s") }
  val b2: Boolean = array.any { it.startsWith("s") }
  println(b1)
  println(b2)
}