import week4._


object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello World")
    val pt = new Pattern_tester()

    val echo = pt.echo _  // assign one function to another, not calling it, You knew it
    println(echo(0))
    println(new Dog("Bull"))
    println(new Person("John", "Alaxander"))

    println(echo("Ishan"))
    println(echo(34))

    println(echo((11,22)))
    println(echo((111,222,333)))

    println(echo(Array(1,2,3,4)))
    println(echo(List()))
  }
}
