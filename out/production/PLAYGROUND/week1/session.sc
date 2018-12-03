object session{
  1+2
  def abs(x: Double) = if (x>0) x else -x

  // Block and limiting the scope
  def sqrt(x:Double) = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) < 0.02

    def improve(guess: Double) =
      (x / guess + guess) / 2

    sqrtIter(1.0)  // Return value of fn
  }
  sqrt(3)
  sqrt(4)
}