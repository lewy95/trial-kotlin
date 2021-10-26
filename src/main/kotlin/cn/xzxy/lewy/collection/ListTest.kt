package cn.xzxy.lewy.collection

import java.util.*

/**
 * list 默认实现是ArrayList 看作可调整大小的数组
 * 1. 数组与list的区别：
 *    数组的大小是在初始化时定义的，永远不会改变，而List没有预定的大小，因此可以把数组看作是可调整大小的数组；
 * 2. list的指定构造；
 * 3. list的复制：两种，直接转换和新引用；
 */
fun generateList() {
  // 不可变集合
  val list = listOf("ym", "yy", "sx", "lq", "lt")
  // 可变集合
  val list2 = mutableListOf("nn", "ly")
  list2.add("lzl")
  list2.remove("ly")
  println(list2.size)
  println(list2)
  // list2.forEach { println(it) }
  // 可变集合可以用val修饰，但是不能对val的集合重新赋值
  //list2 = mutableListOf<String>("pjp", "zmy")
  list2.shuffle() // 随意打乱顺序
  println(list2)

  println("***************************************")
  // list的指定构造
  // 由于默认实现是ArrayList，最好要指定list的大小
  // 实现方式：接受两个参数 List 的大小与初始化函数的构造函数，该初始化函数根据索引定义元素的值
  val doubled = List(5) { it }  // 普通的长度为5的list，也可以使用MutableList
  println(doubled) // [0, 1, 2, 3, 4]
  val doubled2 = List(5) { it * 2 }  // 可以对值进行修改
  println(doubled2) // [0, 2, 4, 6, 8]
  // 指定具体实现类型，变更为 LinkedList
  val linkedList = LinkedList(listOf("one", "two", "three"))
  println(linkedList)
  val linkedList2 = LinkedList<String>()
  linkedList2.add("yy")
  linkedList2.add("oo")
  println(linkedList2)

  println("***************************************")
  // 案例：
  list.filter { it.startsWith("y") }.map { it.toUpperCase() }.forEach { println(it) }

  // 扩展：when与集合，从上往下匹配，只有当上一个不匹配时才判断下一个
  when {
    "ymu" in list -> println("ok")
    "lt" in list -> println("??")
  }
}

fun copyList() {
  // list的复制
  // 要创建与现有集合具有相同元素的集合，可以使用复制操作。
  // 标准库中的集合复制操作创建了具有相同元素引用的 浅 复制集合。
  // 因此，对集合元素所做的更改会反映在其所有副本中。
  val sourceList = mutableListOf(1, 2, 3)
  val copyList = sourceList.toMutableList()
  val readOnlyCopyList = sourceList.toList()
  // sourceList.add(4) // 修改原不影响新的
  copyList.add(3) // 修改新的也不影响原来的
  println("Source size: ${sourceList.size}")
  println("Copy size: ${copyList.size}")
  //readOnlyCopyList.add(4)             // 编译异常
  println("Read-only copy size: ${readOnlyCopyList.size}")

  println("***************************************")
  // 集合之间的转换
  //val copySet = sourceList.toMutableSet() // list转set
  val copySet2 = copyList.toMutableSet() // list转set，会自动去重
  copySet2.add(3)
  //copySet.add(4)
  println(copySet2)

  println("***************************************")
  // 可以创建对同一集合实例的新引用，使用现有集合初始化集合变量时，将创建新引用
  //referenceList.add(4) // 修改新的会修改原的
  sourceList.add(4) // 修改原的会修改新的
  println("referenceList size: ${sourceList.size}")
  println("Source size: ${sourceList.size}")

  val referenceList2: List<Int> = sourceList // 创建新引用时也可以变更可变性
  // referenceList2.add(4)            // 编译错误
  sourceList.add(5)
  println(sourceList)
  println(referenceList2) // 显示 sourceList 当前状态，也就是说还是会相同，只不过变更为不可变后的不能再进行插入
}

// list 迭代器
fun listIterable() {
  val numbers = listOf("one", "two", "three", "four")
  // 获得一个 list 迭代器
  val listIterator = numbers.listIterator()
  while (listIterator.hasNext()) listIterator.next()
  println("Iterating backwards:")
  // 从前往后遍历 hasPrevious
  while (listIterator.hasPrevious()) {
    print("Index: ${listIterator.previousIndex()}")
    println(", value: ${listIterator.previous()}")
  }
}

// mutableListIterator list可变迭代器，可以在迭代列表时插入或替换元素
fun mutableListIterator() {
  val numbers = mutableListOf("one", "four", "four")
  val mutableListIterator = numbers.listIterator()

  mutableListIterator.next()
  mutableListIterator.add("two") // 插入元素
  mutableListIterator.next()
  mutableListIterator.set("three") // 替换元素
  println(numbers)
}


fun main() {
  generateList()

  copyList()

  listIterable()

  mutableListIterator()
}