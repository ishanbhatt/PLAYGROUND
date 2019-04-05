package Implicits

object ImplParam {
  implicit val bob = "Alice"

  def greet(implicit name: String) = println(s"Hello $name!")

  def main(args: Array[String]): Unit = {
    greet
  }

}
