package cn.xzxy.lewy.garmmar

/**
 * 案例：return与标签的说明（在循环中）
 */
fun myReturn(changeFun: () -> Unit) { // 用于传入的高阶函数
  changeFun()
  println("高级函数的Lambda表达式执行完")
}

var list = listOf(1, 2, 3)

// 不使用标签的效果，相当于 break
fun change() {
  list.forEach {
    if (it == 2) return
    println("当前遍历的值是 $it")
  }
  println("list集合遍历完成")
}

// 使用标签的效果，相当于 continue
fun change2() {
  list.forEach {
    if (it == 2) return@forEach
    println("当前遍历的值是 $it")
  }
  println("list集合遍历完成")
}

fun main(args: Array<String>) {
  myReturn { change() }
  println("==========")
  myReturn { change2() }
}