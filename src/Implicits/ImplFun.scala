package Implicits

object ImplFun {

  implicit def intToStr(num: Int) : String = s"The value is $num"

  def funcTakingString(str: String): String =  s"String value is $str"

  def main(args: Array[String]): Unit = {

    println(59.toUpperCase())  // Number do not have toUpperCase so it's string is generated from intToStr
    println(funcTakingString(100)) // funcTakingString expects string, but we gave Int, so conversion happens using intToStr
    println(129.endsWith("9"))
  }
}

