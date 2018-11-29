object Curry{
  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1 else f(a) * product(f)(a+1,b)
  }
  // Rather than defining extra function that gets returned
  // Here it is implied that it will return a function that excepts 2 Ints and return an Int
  // product(f) will return such function but because of Syntactic Sugar
  // That thing is implied
  def fact(n: Int) = product(x => x)(1,n)

  fact(5)

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int ={
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a+1,b))
  }

  def product_mr(f:Int =>Int)(a: Int, b: Int): Int = mapReduce(f, (x,y) => x*y, 1)(a,b)

  product_mr(x=>x)(1,5)
}