package cn.xzxy.lewy.garmmar

fun main() {
  val name = "yy"
  // require 报错：
  // Exception in thread "main" java.lang.IllegalArgumentException: no no
  require(name == "yy") { "no no" }
  val sex = "female"
  // requireNotNull 报错：
  // Exception in thread "main" java.lang.IllegalArgumentException: Required value was null.
  requireNotNull(getSex(sex))
  // check 报错：
  // Exception in thread "main" java.lang.IllegalStateException: Check failed.
  check(name == "yy")
  // checkNotNull 报错：
  // Exception in thread "main" java.lang.IllegalArgumentException: Required value was null.
  checkNotNull(getSex(sex))
}

fun getSex(str: String): String? {
  return if (str.startsWith("f")) str else null
}
