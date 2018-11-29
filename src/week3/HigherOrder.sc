object HigherOrder {
  def id(x: Int) = x
  def square(x: Int) =  x*x
  def cube(x: Int) = x*x*x

  def sum(f: Int=>Int, lower: Int, higher: Int) : Int =
    if (lower > higher) 0
    else f(lower) + sum(f, lower+1, higher)

  def sums(a:Int, b:Int) = sum(id, a, b)
  def sumSquare(a:Int, b:Int) = sum(square, a, b)
  def sumCube(a:Int, b:Int) = sum(cube, a, b)

  sums(1,5)
  sumSquare(1,5)
  sumCube(1,5)
}