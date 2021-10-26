package cn.xzxy.lewy.oop

import kotlin.properties.Delegates

/**
 * 属性委托之非空属性
 * notNull适用于那些无法在最初话阶段就确定属性值的场合
 */
class DelegationNotNull {

  // var address：String // 不赋值会报错
  // 解决办法：可以使用非空属性委托
  var address: String by Delegates.notNull()
}

fun main() {
  val md = DelegationNotNull()
  // 但是使用前必须赋值
  // 不赋值会报错 Property address should be initialized before get
  // println(md.address)
  md.address = "suzhou"
  println(md.address)
}