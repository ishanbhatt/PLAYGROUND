package week5

object Higher_Order {

  // Maps
  def scaleList(xs: List[Int], factor: Int) = xs map(x => x*factor)
  def squareList(xs: List[Int]) = xs map(x => x*x)


  // Filters
  def posElems(xs: List[Int]) = xs filter (x => x >0)
  def negElems(xs: List[Int]) = xs filterNot(x => x>0)
  def parting(xs: List[Int]) = xs partition(x => x>0)
  def taker(xs: List[Int]) = xs takeWhile(x => x>0)
  def dropper(xs: List[Int]) = xs dropWhile(x => x>0)

  //reduce
  def sum(xs: List[Int]) = xs reduceLeft((x,y) => x + y)

  def main(args: Array[String]): Unit = {
    var xs: List[Int] = List(1,2,3,4,5)
    println("MAP")
    println(scaleList(xs,5))
    println(squareList(xs))

    println("FILTER")
    xs = List(3,4,-9,5,1)
    println(posElems(xs))
    println(negElems(xs))
    println(xs partition(x => x>0))
    println(taker(xs))  // take the elements until the predicate turns false, so here it gives 3,4
    println(dropper(xs))  // Opposite of takewhile, list without the prefix taken by takewhile
    println(xs span(x=> x>0))

    println("REDUCE")
    println(sum(xs))
    println(xs reduceRight(_ * _))  // _ represents a new parameter, going from left to right, It knows it has to take two params and do the stuff

    println("FOLDING")
    println((xs foldLeft 23)(_ + _))  // Default addition element, if you have given empty list , you would get 23, else 23 will be added to the final answer

  }
}
