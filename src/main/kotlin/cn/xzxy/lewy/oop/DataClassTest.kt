package cn.xzxy.lewy.oop


/**
 * 数据类，data class ==> 类似java中的lombok
 * 数据类需要满足的条件：
 * 1. 主构造方法至少要有一个参数；
 * 2. 所有的主构造方法参数都需要被标记为var或者val；
 * 3. 数据类不能是抽象的，open / sealed / inner1的；
 *
 * 对于数据类，编译器会自动生成如下内容：
 * 1. hashcode和equals方法；
 * 2. toString方法；
 * 3. 针对属性的componentN方法，并且是按照属性的声明顺序来生成的；
 *
 * 数据类继承的注意点：
 * 1. 如果数据类中定义了equals/hashcode/toString方法，或是在数据类的父类中将这些方法声明为final，那么不会再生成了；
 * 2. 如果父类拥有componentN方法，并且是open的以及返回兼容的签名或是被定义为final的，那么编译器就会报错；
 * 3. 在数据类中显式提供componentN方法以及copy方法实现是不允许的；
 *
 * 解构声明：
 * 在主构造函数中有多少个参数，就会一次生成对于的component1，component2...
 * 这些方法返回的就是对应字段的值，componentN的方法就是用来实现解构声明的
 */
data class Person(val name: String, var age: Int, var address: String)


fun main() {
  val person = Person("lewy", 31, "Poland")
  println(person) // Person(name=lewy, age=31, address=Poland)
  // 如果没有在类前面加上data，则打印的是地址

  val person2 = person.copy(address = "Germany")
  println(person2)

  // 解构声明，顺序必须对应好主构造函数，不然会出现混乱
  val (name, age, address) = person
  println("$name, $age, $address")
}