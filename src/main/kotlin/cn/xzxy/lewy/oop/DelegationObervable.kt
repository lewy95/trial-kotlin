package cn.xzxy.lewy.oop

import kotlin.properties.Delegates

/**
 * 属性委托之可观测属性
 * Delegates.observable 会接收两个参数：初始值和修改处理器
 * 处理器会在每次对属性赋值时得到调用（在赋值完成之后被调用）
 * 处理器本身接收3个参数：被赋值的属性本身，旧值和新值
 *
 * Delegates.vetoable 的调用时机与Delegates.observable 相反
 * 它在出行赋值前被调用，返回的结果是true和false，来决定是否真正对属性赋值
 *
 */
class ObservableDelegation {
  // 需要设置默认值
  var age: Int by Delegates.observable(20) { prop, oldValue, newValue ->
    println("${prop.name}, oldValue: $oldValue, newValue: $newValue")
  }
}

class ObservableDelegation2 {
  var age: Int by Delegates.vetoable(20) { _, oldValue, newValue ->
    when {
      oldValue <= newValue -> true
      else -> false
    }
  }
}


fun main() {
  val od = ObservableDelegation()
  println(od.age)
  od.age = 30 // 打印 age, oldValue: 20, newValue: 30

  println("---------------")
  val od2 = ObservableDelegation2()
  println(od2.age)
  od2.age = 10 // 不满足，不赋值
  od2.age = 30 // 满足，赋值
  println(od2.age) // 30
}