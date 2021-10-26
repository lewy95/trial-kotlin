package cn.xzxy.lewy.clazz

/**
 * 伴生类
 */
object PlayerObject {

    fun goal() {
        println("goaling")
    }
}

/**
 * kotlin中，类没有static方法，多数情况下使用包级别的函数来作为静态方法
 * kotlin会将包级别的函数当作静态方法来看待
 */
class CoPlayer {

    // 伴生对象，一个类中只允许有一个伴生对象
    // 伴生对象的名字不重要，不写也可以，不写会生成一个默认的名字Companion
    companion object PlayerObject {
        // 虽然伴生对象的成员看起来像java中的静态成员，但是在运行期内，依旧是真实对象的实例成员
        // 如果要将其编译为静态方法，需要加上@Jvmstatic注解
        // 伴生对象在编译后会生成一个静态内部类
        var a: Int = 100
        // @JvmStatic // 该注解用于区别编译时生成方法是静态方法还是实例方法，但对使用者而言是无感的，只不过字节码层面有影响
        fun method() {
            println("method invoke")
        }
        fun method2() {
            println("method2 invoke")
        }
    }

    fun getInner(): Unit {
        println(a)
        println(method())
        println(method2())
    }
}

fun main() {

    PlayerObject.goal()

    println("==================")

    println(CoPlayer.a ) // 类似与静态变量
    CoPlayer.method() // 类似与静态方法

    println("==================")
}

