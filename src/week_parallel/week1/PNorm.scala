package week_parallel.week1

object PNorm {

  def power(x: Int, p: Double) = math.exp(p*math.log(abs(x))).toInt

  def sumSegment(a: Array[Int], p: Double, s: Int, t: Int) = {
    var i = s, var sum: Int = 0

    while (i < t) {
      sum += power(a(i), p)  // access element of array by doing a(i) not a[i]
      i += 1
    }
    sum
  }

  // Signature only
  def parallel[A, B](taskA: => A, taskB: => B): (A,B) = {}
  /*
  * This is a generic type method on types A,B
  * Also, the arguments are pass by name (: =>), not pass by value
  * Because the parameters of parallel1 are call by value, a and b are evaluated sequentially in the second case, not in parallel as in the first case.
  * In case of pass by value, val (v1,v2) = parallel(a,b) , a is evaluated first, b is evaluated second, thus making it sequential execution.
  * To run it, we need to pass unevaluated computations
  *
  * */

  def pNormTwoPart(a: Array[Int], p: Double) = {
    val middle = a.length / 2
//    val (sum1, sum2) = (sumSegment(a, p , 0, m), sumSegment(a, p, m, a.length)) // Sequential version
    val (sum1, sum2) = (sumSegment(a,p,0,middle), sumSegment(a,p,middle,a.length))
    power(sum1 + sum2, 1/p)
  }

  def main(args: Array[String]): Unit = {

  }
}
