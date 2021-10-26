package cn.xzxy.lewy.generic

/**
 * 协变与逆变
 *
 * 协变 >>> out，类似与java的 ? extends A
 * 逆变 >>> in，类似与java的  ? super A
 *
 * 以下是逆变的案例
 */
open class IoPerson(val name: String, val age: Int) {
  open fun toWork() {
    println("我是工人$name，我要好好干活！！！")
  }
}

class IoWorker1(name: String, age: Int) : IoPerson(name, age) {
  override fun toWork() {
    println("我是1工人$name，我要好好干活！！！")
  }
}

class IoWorker2(name: String, age: Int) : IoPerson(name, age) {
  override fun toWork() {
    println("我是2工人$name，我也要好好干活！！！")
  }
}

fun main() {
  val personArrayList: MutableList<IoPerson> = ArrayList()
  personArrayList.add(IoPerson("aaa", 11))
  personArrayList.add(IoWorker1("bbb", 12))
  personArrayList.add(IoWorker2("ccc", 13))

  val personArrayList1: MutableList<IoWorker1> = ArrayList()
  personArrayList1.add(IoWorker1("ddd", 14))
  //val personArrayList2: MutableList<IoWorker2> = ArrayList()
  //personArrayList2.add(IoWorker2("eee", 15))
  setWorker2(personArrayList)
  println("----------------")
  setWorker2(personArrayList1)
  //println("----------------")
  //setWorker2(personArrayList2)
}

// 要想这个地方编译成功，必须使用逆变的方式，java中是 ? super A，kotlin中是 in
// 不然 IoPerson 是不适用的
fun setWorker2(studentList: MutableList<in IoWorker1>) {
  for (o in studentList) {
    println("哈哈 " + o.toString())
  }
}
