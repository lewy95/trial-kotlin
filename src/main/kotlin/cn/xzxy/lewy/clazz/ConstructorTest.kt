package cn.xzxy.lewy.clazz

/**
 * 与java的异同：
 * 1. public 可以省略；
 * 2. 类名不需要与文件名相同；
 * 3. kotlin中一个类可以有一个primary构造方法和多个secondary构造方法；
 * 4. 若没有显式提供Primary构造方法，Kotlin会默认为其生成一个无参主构造，这点和Java是一样的，但是属性必须要初始化
 */
/**
 * primary构造方法，直接写在类名后面，可以拥有若干参数
 * 1. primary构造方法中不能写任何逻辑性代码代码，属性赋值由init完成；
 * 2. 若primary构造方法没有任何注解或者是可见性关键字修饰，那么constructor可以省略；
 *    如 class Player private constructor(name: String, age: Int, number: Int) {
 * 3. primary构造方法有且只有一个；
 * 4. 在jvm层面，如果一个primary构造方法的所有参数都有默认值，则jvm还会为其生成一个空构造函数
 */
class Player constructor(name: String, age: Int, number: Int) {

  // 方式一：使用init方法来赋值
  private var name: String = name
  private var age: Int = age
  private var number: Int = number
  private var address: String

  // init 方法完成初始化赋值
  init {
    this.address = "MUNICH"
  }


  // 方式二：直接在定义变量时赋值，不写在init中
  // private var address: String = "MUNICH"

  //====================================

  // 方式三：直接省略不写，将属性都在参数中声明即可，甚至花括号都可以不写
  // 即 class Player constructor(name: String, age: Int, number: Int)

  override fun toString(): String {
    return "Player(name='$name', age=$age, number=$number, address='$address')"
  }

}

// 若没有显式提供Primary构造方法，Kotlin会默认为其生成一个无参主构造，这点和Java是一样的
// 但属性必要进行初始化
//class PlayerDemo {
//    private val name: String = "aa" // 不初始化会报错，可以使用String?解决
//    private val age: Int? = null
//    private val number: Int? = null
//}

fun main() {
  val player = Player("muller", 31, 25)
  println(player.toString())

}
