package week7

object RandomGen {
  def main(args: Array[String]): Unit = {

    // A very neat example of parameterized traits' implementation
    val integers = new Generator[Int] {
      val rand = new java.util.Random()
      override def generate: Int = rand.nextInt()
    }

    val booleans = new Generator[Boolean] {
      override def generate: Boolean = integers.generate > 0
    }

    val pairs = new Generator[(Int, Int)] {
      override def generate: (Int, Int) = (integers.generate, integers.generate)
    }

    println(integers.generate)
    println(booleans.generate)
    println(pairs.generate)
  }
}
