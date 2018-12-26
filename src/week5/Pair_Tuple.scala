package week5

object Pair_Tuple {

  def msort(xs: List[Int]) : List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else{
      /*
      * A lot of things are going in the def below
      * Pattern matching is being done on a tuple
      * x::xs1 -> x is head, xs1 is tail
      *
      * */
      def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
        case (Nil, ys) => ys // Have to use => as it is case not if statement
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (x < y) x::merge(xs1, ys)
          else y::merge(xs, ys1)
      }
      val (fst,snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }

  def main(args: Array[String]): Unit = {
    val pair = ("answer", 42)
    println(pair)

    var (label, value) = pair  // Kind of pattern matching
    // You can also do, Idiotic, as it starts with 1
    label = pair._1
    value = pair._2

    val xs: List[Int] = List(3,6,1,2,9,7,5)
    println(msort(xs))
  }
}
