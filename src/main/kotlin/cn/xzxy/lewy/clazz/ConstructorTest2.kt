package cn.xzxy.lewy.clazz

/**
 * secondary构造方法需要放在类体中，可以有0个，1个，多个
 * secondary构造方法都是基于primary构造方法来实现的
 */
class Player2 constructor(private var name: String, private var age: Int = 0) {

  private var address: String

  // init 方法完成初始化赋值
  init {
    this.name = "lewy"
    this.age = 31
    this.address = "MUNICH"
  }

  // 次构造方法是基于主构造函数实现的，且次构造函数中this后的参数必须和主构造函数一样
  // 前提是主构造函数上没有 @JvmOverloads 修饰
  // 如果有 @JvmOverloads 修饰，this后的参数可以小于主构造函数的参数，可见 ConstructorTest3
  constructor(name: String, age: Int, address: String) : this(name, age) {
    this.address = address
  }
}

fun main() {
  val player2 = Player2("muller", 31, "GER")
  println(player2.toString())

}
