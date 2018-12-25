package week6

import scala.io.Source

object PhonesNumbers {
  def main(args: Array[String]): Unit = {
    val in = Source.fromURL("https://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")
    val words = in.getLines().toList filter (word => word forall (chr => chr.isLetter))


    val mnem = Map(
      '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
      '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ"
    )

    val charCode: Map[Char, Char] =
      for((digit, str) <- mnem; ltr <- str) yield ltr -> digit
    // Here val is a method not function,you could write it with def as well
    // Here charCode is a Map, and as we know map can be used as method as well
    // And that is used in wordCode
    // Coolness of scala, val can be such complex expression

    def wordCode(word: String): String = word.toUpperCase() map charCode
    // Had to do upper case

    println(wordCode("ISHAN"))

    val wordsForNum: Map[String, Seq[String]] =
      words groupBy wordCode // wordCode is the discriminator function

    println(wordsForNum("5282"))
  }


}
