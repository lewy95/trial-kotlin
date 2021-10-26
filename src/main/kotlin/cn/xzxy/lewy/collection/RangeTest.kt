package cn.xzxy.lewy.collection

/**
 * 区间和数列 range
 *
 */
fun generateRange() {
  // 声明方式
  //val r1 = 1..10 // 步长为1，隐式调用
  //val r11 = 1.rangeTo(10) // 步长为1
  //val r2 = 1..10 step 2 // 步长为2
  //val r22 = 1.rangeTo(10) step 2 // 步长为2
  //val r3 = 10.downTo(1) // 步长为1，降序
  val r33 = 10.downTo(1) step 2 // 步长为2，降序

  for (r in r33) println(r)

  println("---------------------------------")

  // util 和 to 的区别:
  for (i in 1 until 10) {       // i in [1, 10), 10被排除
    print(i)
  }
  println()
  for (i in 1.rangeTo(10)) {       // i in [1, 10], 10在内
    print(i)
  }
}

fun main() {
  generateRange()
}
