package cn.xzxy.lewy.generic

/**
 * 协变与逆变
 *
 * 协变 >>> out，类似与java的 ? extends A
 * 逆变 >>> in，类似与java的  ? super A
 *
 * 以下是协变的案例
 */
open class OiPerson(val name: String, val age: Int) {
  open fun toWork() {
    println("我是工人$name，我要好好干活！！！")
  }
}

class OiWorker1(name: String, age: Int) : OiPerson(name, age) {
  override fun toWork() {
    println("我是1工人$name，我要好好干活！！！")
  }
}

class OiWorker2(name: String, age: Int) : OiPerson(name, age) {
  override fun toWork() {
    println("我是2工人$name，我也要好好干活！！！")
  }
}

fun main() {
  val personArrayList: MutableList<OiPerson> = ArrayList()
  personArrayList.add(OiPerson("aaa", 11))
  personArrayList.add(OiWorker1("bbb", 12))
  personArrayList.add(OiWorker2("ccc", 13))

  val personArrayList1: MutableList<OiWorker1> = ArrayList()
  personArrayList1.add(OiWorker1("ddd", 14))
  val personArrayList2: MutableList<OiWorker2> = ArrayList()
  personArrayList2.add(OiWorker2("eee", 15))
  setWork(personArrayList)
  println("----------------")
  setWork(personArrayList1)
  println("----------------")
  setWork(personArrayList2)
}

// 要想这个地方编译成功，必须使用协变的方式，java中是 ? extends A，kotlin中是 out
// 即这个地方本质是 fun setWork(studentList: List<out OiPerson>) {
// 但是由于 Kotlin 中 List 是只读的，肯定安全，所以官方在定义 List 接口的时候就直接定义成了协变的
fun setWork(studentList: List<OiPerson>) {
  for (o in studentList) {
    o.toWork()
  }
}