package cn.xzxy.lewy.generic

/**
 * 泛型擦除
 * Kotlin 为泛型声明用法执行的类型安全检测仅在编译期进行
 * 运行时泛型类型的实例不保留关于其类型实参的任何信息，其类型信息将被擦除,
 * 例如 Foo<Bar> 与 Foo<Baz?> 的实例都会被擦除为 Foo<*>
 */
class MyStorage<out T>(private var t: T) {
  fun getValue(): T {
    return this.t
  }

  // @UnsafeVariance的含义是型变点违例，告诉编译器不要管
  fun setValue(t: @UnsafeVariance T): Unit {
    this.t = t
  }
}

fun main(args: Array<String>) {
  val myStorage: MyStorage<Int> = MyStorage(9)
  val myStorage2: MyStorage<Any> = myStorage

  println(myStorage2.getValue()) // 9

  myStorage2.setValue("oo") // 起初类型是int，这里可以存入string
  println(myStorage2.getValue()) // "oo"
}