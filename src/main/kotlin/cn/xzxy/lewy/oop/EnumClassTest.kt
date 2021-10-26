package cn.xzxy.lewy.oop

/**
 * 枚举类
 */
enum class Season {
  SPRING, SUMMER, AUTUMN, WINTER
}

enum class Season2(val temperature: Int) {
  SPRING(20), SUMMER(38), AUTUMN(15), WINTER(6)
}

enum class Season3 {
  SPRING {
    override fun getSeason(): Season3 = SPRING
  },
  SUMMER {
    override fun getSeason(): Season3 = SUMMER
  },
  AUTUMN {
    override fun getSeason(): Season3 = AUTUMN
  },
  WINTER {
    override fun getSeason(): Season3 = WINTER
  };

  abstract fun getSeason(): Season3
}

fun main() {
  val season = Season.values()
  season.forEach { println(it) }

  println(Season2.valueOf("SPRING").temperature)

  println(Season3.valueOf("SPRING"))
}

