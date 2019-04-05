package Implicits

object ObjectImpl {

  trait Monoid[A] {
    def zero: A
    def plus(a: A, b: A): A
  }
  //Here we use implicit objects that are basically singletons which can be used in implicit parameters list.

  implicit object IntegerMonoid extends Monoid[Int] {
    override def zero: Int = 0
    override def plus(a: Int, b: Int): Int = a + b
  }

  implicit object StringMonoid extends  Monoid[String] {
    override def zero: String = ""
    override def plus(a: String, b: String): String = a.concat(b)
  }

  // Default addition element, that is ev.zero
  def summation[A](values: Seq[A])(implicit ev: Monoid[A]) = values.foldLeft(ev.zero)(ev.plus)

  def main(args: Array[String]): Unit = {
    val xint: List[Int] = List(1,2,3,4,5)
    val xs: List[String] = List("Hello ", "How ", "Are ", "You?")

    println(summation(xint))
    println(summation(xs))
  }

}
