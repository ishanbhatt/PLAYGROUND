package week5

object List_Tester {

  def removeAt(n: Int, xs: List[Int]) = (xs take n) ::: (xs drop n + 1)

  def main(args: Array[String]): Unit = {
    val l: List[Int] = List(1,2,3,4,5,6)
    println(l)

    println(l.length)
    println(l.head)
    println(l.tail)
    println("---------------------------------------")
    println(l.last)
    println(l.init)
    println("----- TAKE --------- DROP--------------")
    println(l take(3))
    println(l drop(2))
    println("-----REVERSE---------UPDATE-------INDEX-------CONTAINS-----")
    println(l.reverse)
    println(l.updated(3,10))  // Update 3rd element with 10
    println(l.contains(4))
    println(l.indexOf(6))

    println(removeAt(3,l))
    println(l :: List(1,2,3))  // See the diff in output
    println(l ::: List(1,2,3))

    val (fst, snd) = l splitAt 3  // These two lists are returned in a pair, Generalization of pair is tuple
    println(fst)
    println(snd)
  }
}
