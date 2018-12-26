package week5
import math.Ordering

object Impl_Param {
  def msort[T](xs: List[T])(implicit ord: Ordering[T]) : List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else{
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys // Have to use => as it is case not if statement
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (ord.lt(x,y)) x::merge(xs1, ys)
          else y::merge(xs, ys1)
      }
      val (fst,snd) = xs splitAt n
      merge(msort(fst), msort(snd))
      merge(msort(fst), msort(snd))
    }
  }

  def main(args: Array[String]): Unit = {
    val nums = List(9,2,1,4,5,8)
    val fruits = List("apple", "pinapple", "grapes", "guava", "banana")
    println(msort(nums))  // No need to specify type of x,y they are inferred
    println(msort(fruits)) // No need to specify ordering parameter as it is an implicit, default parameter
                            // You can pass object/function as an implicit params in Scala
  }
}
