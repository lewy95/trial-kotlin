package cn.xzxy.lewy.garmmar

/**
 * 单层for循环
 */
fun testBreak() {
  for (j in 0..10) {
    if (j == 5) {
      println("当前值为 $j， 使用break标签 跳出循环")
      break
    } else {
      println("当前值为 $j，使用continue标签继续下一次循环")
      continue
    }
  }
}

/**
 *  嵌套for循环，通过指定标签跳转到指定for循环中
 *  1. 自定义一个标签：xxx@
 *  2. 在for循环中添加自定义的标签，使用break@xxx或者continue@xxx，来转跳
 */
fun testBreak2() {
  loop@ for (j in 0..10) {
    for (i in j..10) {
      if (i == 5 && j == 5) {
        println("当外层值为 $j 内层值为$i， 使用break标签 跳出循环")
        break@loop
      } else {
        println("当外层值为 $j 内层值为$i，使用continue标签继续下一次循环")
        continue@loop
      }
    }
  }
}

fun main() {
  testBreak()
  println("========================")
  testBreak2()
}