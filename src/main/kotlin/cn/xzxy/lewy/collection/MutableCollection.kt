package cn.xzxy.lewy.collection

fun List<String>.getShortWordsTo(shortWords: MutableList<String>, maxLength: Int) {
  // 过滤长度大于3的字符串
  this.filterTo(shortWords) { it.length <= maxLength }
  val articles = setOf("a", "A", "an", "An", "the", "The")
  println(shortWords)
  println(articles)
  // -= ?
  shortWords -= articles
}

fun main() {
  val words = "A long time ago in a galaxy far far away".split(" ")
  val shortWords = mutableListOf<String>()
  words.getShortWordsTo(shortWords, 3)
  println(shortWords)
}