package cn.xzxy.lewy.clazz

/**
 * JvmOverloads注解的使用
 * 在有默认参数值的方法中使用，则Kotlin就会暴露多个重载方法。
 * 即若参数为  fun f(a: String, b: Int=0, c:String="abc"){ }
 * 则会生成：  f(String a)  f(String a, int b)  f(String a, int b, String c) 三个方法
 */
class Player3 @JvmOverloads constructor(
  private var name: String,
  private var age: Int = 0,
  private var nation: String = "CHN"
) {

  private var address: String

  // init 方法完成初始化赋值
  init {
    this.name = "lewy"
    this.age = 31
    this.nation = "CHN"
    this.address = "MUNICH"
  }

  // 次构造方法是基于主构造函数实现的
  constructor(name: String, age: Int, nation: String, address: String) : this(name, age, nation) {
    this.address = address
  }

  // 使用@JvmOverloads后，this后的参数可以比主构造函数中少
  constructor(name: String, address: String) : this(name) {
    this.address = address
  }

  constructor(name: String, nation: String, address: String) : this(name, nation) {
    this.address = address
  }
}

fun main() {
  val player = Player3("muller", 31, "GER")
  println(player.toString())

  val player2 = Player3("muller")
  println(player2.toString())

  val player3 = Player3("muller", "GER")
  println(player3.toString())

}
