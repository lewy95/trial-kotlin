package cn.xzxy.lewy.clazz

interface PlayerService {

  fun goal() {
    println("goaling from interface")
  }
}

open class PlayerService2(name: String?, age: Int) {
  open fun goal() {
    println("goaling from class")
  }
}

/**
 * 可以同时实现接口和继承类，继承类需要
 * 注意：当一个类同时实现接口和继承类中都有有同一个method，则必须要重写这个方法
 */
class PlayerServiceImpl(name: String?, age: Int) : PlayerService, PlayerService2(name, age) {

  override fun goal() {
    super<PlayerService>.goal() // 表示调用PlayerService中的方法
    super<PlayerService2>.goal() // 表示调用PlayerService2中的方法
  }
}