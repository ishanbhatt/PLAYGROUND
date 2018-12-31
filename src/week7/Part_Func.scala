package week7

object Part_Func {
  def main(args: Array[String]): Unit = {
    val f: String => String = {case "ping" => "pong"}  // Returns a function which is a map of String=>String
    println(f("ping"))  // As it returns a map, you cant do f(), You need to put in a key

    val fu: PartialFunction[String, String] = {case "ping" => "pong"}
    println(fu.isDefinedAt("ping"))
    println(fu.isDefinedAt("abc"))

    val fun: PartialFunction[List[Int], String] = {
      case Nil => "one"
      case x::y::rest => "two"
    }

    println(fun.isDefinedAt(List(1,2,3)))
  }
}
