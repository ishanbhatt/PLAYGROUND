package week6

object Vector_Ops {

  def scalarProduct(xs: Vector[Int], ys: Vector[Int]) =
    (xs zip ys).map(xy => xy._1 * xy._2).sum
  // Here xy is the zipped value
  // xy._1 gives xs' element and xy._2 gives ys' element
  // map takes list, gives list , so you sum it up to get scalar product

  def scalarProductParam(xs: Vector[Int], ys: Vector[Int]) =
    (xs zip ys).map{ case (x,y) => x*y}.sum
  // case is a multi line statement, so you need {}instead of ()
  // Also, this case is short hand for the match expression of the function argument

  def isPrime(n: Int): Boolean = (2 until n).forall(d => n%d != 0)

  def main(args: Array[String]): Unit = {
    val nums: Vector[Int] = Vector(1,2,3,4,5,6,7,8)
    val people = Vector("Bob", "Alice")
    println(nums)
    println(people)

    val arr_nums: Array[Int] = Array(1,3,4,5)
    println(arr_nums.mkString(","))  // Simply printing gives object code ,so you have to do something fancy

    println("---------RANGE-----------")
    val r = 1 until 5
    val s = 1 to 10 by 3 // 1 to 10 by 3 steps
    println(r)
    println(s)

    println("---------------SEQUENCE OPS------------------")
    println(arr_nums exists(x => x%10==0))  // any
    println(nums forall(x => x>0))  // all
    val zipper = nums zip people  // Same as zip of python
    println(zipper)
    println(zipper.unzip)  //Original structure of 2 vectors
    val str: String = "HELLO WORLD"
    println(str flatMap(c => List(".",c)))  // Creates a list with all element being .C, but then we flatten it to single list


    val xs = Vector(1,2,3)
    val ys = Vector(4,5,6)
    println(scalarProduct(xs, ys))
    println(scalarProductParam(xs,ys))
    println(isPrime(5))
    println(isPrime(78))

    println("------------------SOME FLATTENING---------------------")
    println(xs map (x=> x*x*x))

    def g(n:Int) = List(n-1, n, n+1)
    println(xs.map(x=>g(x)))  // Gives Vector of list
    println(xs.flatMap(x=>g(x)))  // Gives flattened vector 1 level vector



  }
}
