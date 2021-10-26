package cn.xzxy.lewy.oop

class Student(val name: String, val age: Int) {

  private val str: String = "Student属性"

  private inner class StudentFeature(var height: Int, var weight: Int) {

    private val str: String = "StudentFeature属性"

    fun getStudentFeature() {
      println("height: $height, weight: $weight")

      val str: String = "局部变量"

      // 调用各区域内属性的方式
      println(this@Student.str)
      println(this.str)
      println(str)

    }
  }

  private fun method() {
    println("执行了Student的method方法")
  }

  fun getStudent() {
    val studentFeature = StudentFeature(180, 70)
    studentFeature.getStudentFeature()
  }
}

fun main() {
  val student = Student("muller", 30)
  student.getStudent()
}