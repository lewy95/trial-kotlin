package cn.xzxy.lewy.generic

/**
 * Kotlin 使用处型变：类型投影
 * 类型投影产生的原因：
 * Array类中get(out协变)和set(in逆变)方法泛型冲突(既有逆变又有协变)
 */
fun copy(from: Array<Any>, to: Array<Any>) {
  assert(from.size == to.size)
  for (i in from.indices)
    to[i] = from[i]
}

// Array<out Any> 即类型投影
fun copyPro(from: Array<out Any>, to: Array<Any>) {
  assert(from.size == to.size)
  for (i in from.indices)
    to[i] = from[i]
}

fun main() {
  val from: Array<Int> = arrayOf(1, 2, 3)
  val to = Array<Any>(3) { "hello$it" }
  // copy(from, to) // 编译失败，报错：其类型为 Array<Int> 但此处期望 Array<Any>，意思就是要进行协变
  // 协变，需要在类型前加上out，本质上就是? extends Any，如copyPro即正确，此处的out就称为使用处协变，和java一样
  copyPro(from, to) // 编译通过
}

