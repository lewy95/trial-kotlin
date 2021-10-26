package cn.xzxy.lewy.reflect

import kotlin.reflect.KClass

class ClassRefer {
}

fun main() {

  // 获取 kotlin 类对象
  val classRefer: KClass<ClassRefer> = ClassRefer::class
  println(classRefer.isData)
  println(classRefer.isFinal)
  println(classRefer.isInner)
  println(classRefer.isSealed)



  // 获取 java 类对象
  // val classReferJava: Class<ClassReferJava> = ClassReferJava::class.java
  // 将 java 类转化为 kotlin 类
  // val classRefer2: KClass<ClassReferJava> = classReferJava.kotlin

}