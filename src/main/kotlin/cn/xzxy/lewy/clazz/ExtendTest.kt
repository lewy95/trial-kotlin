package cn.xzxy.lewy.clazz

/**
 * kotlin 中所有类都是不能被继承中，即都是final的
 * 当前 kotlin 提供了其他的方法来实现继承 >>> open 关键字 >>> open与final含义相反
 */
open class Parent(name: String, age: Int) {
  open val name: String = "parent" // 必须是open的属性才能被继承
  // 且 val 变量可以被 val 和 var 重写
  // 但是 var 变量只能被 var 重写，不能被 val 重写
  // 本质上 val 是只读的，即get，而 var 是 get 和 set

  open fun eat() { // 必须是open的方法才能被继承
    println("eating")
  }
}

open class Child(name: String, age: Int) : Parent(name, age) {
  override val name = "child"

  final override fun eat() { // 子类中再声明为 final 不允许下级子类重写
    super.eat() // 调用父类方法

    println("child eating")
  }
}

class Child2(override var name: String, age: Int) : Parent(name, age) {
  // 可以直接在参数中重写
}

//class ChildChild(name: String, age: Int) : Child(name, age){
//    override fun eat(): Unit {  // 无法继承
//        println("eating")
//    }
//}


fun main() {
  val child = Child("lewy", 21)
  println(child.name)
  child.eat()
}