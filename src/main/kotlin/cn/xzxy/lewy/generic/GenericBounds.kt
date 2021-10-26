package cn.xzxy.lewy.generic

/**
 * 泛型约束：来设定一个给定参数允许使用的类型
 * 最常见的约束是上界，上界的概念：
 * java中extend后的就是上界；kotlin中冒号后面指定的类型即上界
 * 如 fun <T : Comparable<T>> sort(list: List<T>) {  …… }
 * T 的上界是 Comparable<T>，因此泛型参数只允许是 Comparable<T> 的子类型
 */
class UpperBoundsClass<T : List<T>> {
  // 上界是 List<T>，只能传List及它以上的类型才行
}

// 当泛型参数有多个上限时，kotlin使用where关键字还声明，多个之间通过逗号分隔
class UpperBoundsClass2<T> where T : Comparable<T>, T : Any {
}

fun main() {
  // 该案例中很明显String既是Comparable和Any的子类型
  val upperBoundsClass = UpperBoundsClass2<String>()
}