package cn.xzxy.lewy.oop

import kotlin.reflect.KProperty

/**
 * 委托：属性委托
 */
class MyDelegate {
  operator fun getValue(thisRef: Any?, property: KProperty<*>): String =
    "$thisRef, your delegated property name is ${property.name}"

  operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) = println("$thisRef, now value is $value")
}

class MyPropertyClass {
  var str: String by MyDelegate()
}

fun main() {
  val myPropertyClass = MyPropertyClass()
  myPropertyClass.str = "hello yy"
  // print cn.xzxy.lewy.oop.MyPropertyClass@2d3fcdbd, now value is hello yy
  println(myPropertyClass.str)
  // print cn.xzxy.lewy.oop.MyPropertyClass@2d3fcdbd, your delegated property name is str
}

/**
 * 关于属性委托的要求：
 * 对于只读属性来说（val修饰的属性），委托属性提供一个名为getValue的方法，该方法接收如下参数：
 * 1. thisRef：需要是属性拥有者相同的类型或其父类型（对于扩展属性来说，这个类型指的是被扩展的那个类型）
 * 2. property：需要是KProperty<*>类型或是其父类型
 *
 * getValue方法需要返回与属性相同的类型或是其子类型
 *
 * 对于可变属性来说（var修饰的属性），委托需要再提供一个名为setValue的方法，该方法需要接收如下参数：
 * 1. thisRef：与getValue方法的thisRef要求一致
 * 2. property：与getValue的property要求一致
 * 3. new value：需要与属性的类型相同或是父类型
 *
 * getValue与setValue方法既可以是作为委托的成员方法实现，也可以扩展方法来实现
 * 这两个方法都必须标记为operator关键字，对于委托类来说，它可以实现ReadOnlyProperty或是ReadWriterProperty接口
 * 这些接口包含了相应的getValue和setValue方法，同时，对于委托类来说，也可以不去实现这两个接口，而是自己单独实现
 * 相应的getValue方法
 *
 * 委托转换原则：
 * 对于每个委托属性来说，Kotlin编译器在底层会生成一个辅助的属性，然后将原油属性的访问委托给这个辅助属性
 * 比如说，对于属性prop来说，kotlin编译器所生成的隐含属性名为prop$delegate的属性
 * 然后对原有的prop属性的访问器的访问都只是委托给了这个额外的，Kotlin编译器所生产的辅助属性
 */
