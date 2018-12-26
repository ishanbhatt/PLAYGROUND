package week6

object Comb_Search {
  def main(args: Array[String]): Unit = {
    val n = 7
    val pairs = (1 until n) map (i => (1 until i).map(j => (i,j))) // It is a vector of vectors
    val flattened_pairs = pairs.flatten
    println(flattened_pairs)

    val fm_pairs = (1 until n) flatMap (i => (1 until i).map(j => (i,j)))
    // In pairs, as the inner loop gives you a Vector of vector,you can flatMap it beforehand
    // So there are some occasions where you want to return a sequence or list from the function
    // flatMap works applying a function that returns a sequence for each element in the list,
    // and flattening the results into the original list
    println(fm_pairs)

    def isPrime(n: Int) = (2 until n).forall(n %_ != 0)
    // Again a trickery, no need to take d and do d => n % d !=0
    println(fm_pairs filter (pair => isPrime(pair._1 + pair._2)))

    println("---------------PAIRS WITH LOOPS---------------------")

    println(for { i <- 1 until n
          j <- 1 until i
          if isPrime(i+j)
    } yield (i,j))



  }
}
