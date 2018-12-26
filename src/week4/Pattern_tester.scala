package week4

class Pattern_tester {

  def echo(x: Any): String = x match {

    // constants
    case 0 => "zero"
    case true => "true"
    case "hello" => "You said 'hello'"
    case Nil => "an empty list"

    // sequence patterns
    case List(0, _, _) => "Three element list with 0 as first element"
    case Vector(1, _*) => "vector starting with 1 with n elements"

    // tuples
    case (a,b) => s"got $a and $b"
    case (a,b,c) => s"got $a $b and $c"

    // constructor
    case Person(first, "Alaxander") => s"found an Alaxander with $first"
    case Dog(name) => s"found a dog name $name"

    //typed patterns
    case s: String => s"I got this string $s"
    case i: Int => s"thanks for the int $i"
    case a: Array[Int] => "Got an array"
    case list: List[_] => s"thanks for the list $list"
    case m: Map[_,_] => m.toString

    case _ => "Unknown"
  }

}

case class Person(val FirstName: String, var LastName: String)
case class Dog(val Name: String)
