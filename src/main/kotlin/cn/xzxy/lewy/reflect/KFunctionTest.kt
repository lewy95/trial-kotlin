package cn.xzxy.lewy.reflect

fun look(name: String) {
  println("looking at $name")
}

fun main() {
  val func = ::look
  func.invoke("mm")
  func.call("yy")
}
