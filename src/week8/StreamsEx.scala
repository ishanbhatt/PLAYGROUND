package week8

object StreamsEx {
  def isPrime(n: Int) = (2 until n) forall(n % _ != 0)

  def main(args: Array[String]): Unit = {

    var third = ((1000 to 100000) filter(isPrime))(2) // Loops from 1000,10000 to get all primes and then gives 3rd prime
    println(third)

    // Avoid computing the tail until it is needed for evaluation result
    var xs = Stream(1,2,3)
    println(xs)  // prints Stream(1,?) means that tail is not evaluated yet

    third = ((1000 to 10000).toStream filter(isPrime))(2)
    println(third)

    // x::xs produces a list, never a stream., So you do x#::xs

  }
}
