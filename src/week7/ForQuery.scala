package week7

object ForQuery {
  def main(args: Array[String]): Unit = {
    val books: List[Book] = List(
      new Book(title = "Structure of Programs", authors = List("Abelson", "Sussman")),
      new Book(title = "Into to Functional Programming", authors = List("Bird", "Wedler")),
      new Book(title = "Effective Java", authors = List("Joshua")),
      new Book(title = "Java Puzzlers", authors = List("Joshua", "Gafter")),
      new Book(title = "Programming in Scala", authors = List("Odersky", "Spoon", "Bill"))
    )

    println("Find title of books whose author's name is Bird")
    for (b <- books; a<-b.authors if a.startsWith("Joshua"))
      println(b.title)

    println("Word Program in the title")
    for (b <- books; if b.title.indexOf("Program") >= 0)
      println(b.title)

    println("Authors with at least two books")
    for {
      b1 <- books
      b2 <- books
      if b1 != b2
      a1 <- b1.authors // Here a1,a2 are not lists rather they are element in the list
      a2 <- b2.authors
      if a1 == a2
    }
      println(a1.distinct)

    // As long as client interface to the DB defines the methods
    // map, flatmap, withfilter, we can use the syntax for querying DB
    // Used in ScalaQuery, Slick, LINQ
  }



}
