object HigherOrderAnon {
  def sum(f: Int=>Int, lower: Int, higher: Int) : Int =
    if (lower > higher) 0
    else f(lower) + sum(f, lower+1, higher)

  def sums(a:Int, b:Int) = sum(x=>x,a,b)
  def sumSquare(a:Int, b:Int) = sum(x=>x*x, a, b)
  def sumCube(a:Int, b:Int) = sum(x=>x*x*x, a, b)

  sums(1,5)
  sumSquare(1,5)
  sumCube(1,5)

}