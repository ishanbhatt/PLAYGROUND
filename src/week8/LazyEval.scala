package week8

object LazyEval {

  def expr ={
    val x = { print("x"); 1}
    lazy val y = { print("y"); 2}
    def z = { print("z"); 3}
    z + y + x + z + y + x
  }

  // Infinite stream from given integer n
  // As, streams are evaluated lazily, the RHS will be evaluated only when we ask for 2nd, 3rd element
  def from(n: Int): Stream[Int] = n #:: from(n+1)

  def main(args: Array[String]): Unit = {
    expr
    /*
    * val x, will be evaluated immedietly.
    * lazy y, it will be evaluated when it is called , that is in the z+y
    * So, to conclude,
    * def is evaluated every time it is called, evaluated when it is called
    * val is evaluated immediately and evaluated only once
    * lazt val is evaluated only when it is needed and evaluated only once
    * */

    val naturals = from(0)
    val mult_four = naturals map (_ * 4)

    println((mult_four take 25).toList)

    def sieve(s: Stream[Int]): Stream[Int] =
      s.head #:: sieve(s.tail filter (_ % s.head != 0))  // Cool method to get list of all primes

    val primes = sieve(from(2))
    println((primes take(20)).toList)


  }
}
