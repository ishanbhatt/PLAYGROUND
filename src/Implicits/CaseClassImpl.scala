package Implicits

object CaseClassImpl {

  // You can use similar stuff to extend the library
  // Any string will be converted to StringOps
  // You retain all the functionality of String and get some more from StringOps
  case class StringOps(str: String) {
    def yell = str.toUpperCase() + "!!!"
    def isQuestion = str.endsWith("?")
  }

  implicit def stringToStringOps(str: String) = StringOps(str)  // worked without new as StringOps is a case class

  def main(args: Array[String]): Unit = {
    println("Hello World".yell)
    println("Are you nuts?".isQuestion)
    println("Ishan".toUpperCase)
  }
}
