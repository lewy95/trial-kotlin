package cn.xzxy.lewy.clazz

/**
 * 属性说明：
 * 1. 可以直接在类名后定义参数，也可以设置初始值;
 * 2. getter/setter 方法；
 * 3. lateinit 延迟初始化：
 *    kotlin要求非空类型的属性必须要在构造方法中进行初始化，有时不太方便，就可以通过lateinit来延迟初始化；
 * 4. 可见性：四种public/protected/internal/private，区别于java
 *    private:只能在该文件下使用
 *    internal:只能在同一个模块下使用
 *    protected:不能用于顶层
 *    public:到哪都能用
 * 5. var / val / const val 区别：
 *    var 定义私有变量，带有公有的set/get方法
 *    val 定义私有常量，但只带有公有的get方法
 *    const val 定义私有常量，但只带有公有的set/get方法，只能定义在最外层或object中
 */


class Club(name: String, private val nation: String = "GER") {

  // const 只能定义在最外层，不能在类中定义
  // const val yy = "oo"

  // Kotlin 要求类中属性必须初始化，
  // val street: String // 报错：Property must be initialized or be abstract
  // val street: String = null // 报错：Null can not be a value of a non-null type String
  // var street: Street? = null // 正确方式

  /**
   * 关于lateinit：
   * 1. 只能用在类体声明的var上，不能用在primary构造方法的属性上;
   * 2. 属性不能拥有自定义的setter和getter；
   * 3. 属性类型需要非空（不能是String?类似的），且不能是基本数据类型；
   */
  lateinit var address: String // 延迟初始化

  var name: String? = name
    // 标准的getter/setter方法，初始化时默认有
    get() {
      println("get invoke")
      return field
    }
    set(value) {
      // field = value // 最基础的
      println("old value $field")
      println("new value $value")
      // 还可以实现更多的操作
      field = if (value == null) {
        println("set invoke to branch 1")
        value
      } else {
        println("set invoke to branch 2")
        value
      }
    }

  companion object {
    // const定义点1：
    const val yy = "oo-1"
  }

  // 测试调用 const val 属性
  fun invokeConstVal() {
    println(ConstValObject.yy) // 调用伴生类中的
    println(yy) // 若有伴生对象，则调用伴生对象中，否则调用顶层中的
  }

  // toString方法
  override fun toString(): String {
    return "Club(nation='$nation')"
  }
}

// const定义点2：顶层
// const val yy = "oo-2"

object ConstValObject {
  // const定义点3：伴生类
  const val yy = "oo-3"
}


fun main() {
  val club = Club("FCB")
  club.invokeConstVal()

  // test set
  club.address = "MUNICH"
  println(club.address)

  club.name = null
  club.name = "HAM"
  println(club.name)

  // kotlin 空安全设计，不允许这样写，在多线程情况下，仍会出现空值情况
  // Smart cast to 'Street' is impossible, because 'club.street' is a mutable property that could have been changed by this time
  // if (club.street != null) {
  //     club.street.name = "aaa"
  // }

}


//data class Street(
//  var name: String
//)