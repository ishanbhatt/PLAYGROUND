package week6

object Sets_Maps_Ops {


  def main(args: Array[String]): Unit = {
    val fruit = Set("apple", "banana", "orange")
    val s = (1 to 6).toSet
    println(fruit)
    println(s)

    println("--------------OPERATIONS-------------------")
    println(s map (_ + 2))
    println(fruit filter (_.startsWith("ap")))
    println(s.nonEmpty)

    println("---------------MAPS---------------------------")
    val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
    val capitalOfCountry = Map("US"->"Washington", "India" -> "Delhi")
    println(romanNumerals)
    println(capitalOfCountry("US"))  //Maps are function
//    println(capitalOfCountry("UK")) NoSuchElementException
    println(capitalOfCountry get "UK")
    println(capitalOfCountry get "India")

    def showCapital(country: String) = capitalOfCountry get country match {
      case Some(capital) => capital  // Here you are matching some capital , you could put any literal instead of capital
      case None => "Missing Data"
    }

    println(showCapital("Pakistan"))
    println(showCapital("India"))

    println("------------SORTED GROUPBY-------------------")
    val fruits: List[String] = List("apple", "pear", "banana", "pineapple")

    println(fruits.sorted)
    println(fruits sortWith(_.length < _.length))

    println(fruits groupBy(_.head))  // Partitions collection into map using discriminator function f (_.head)

    val cap1 = capitalOfCountry withDefaultValue "Unknown"
    println(cap1("Uganda"))
  }
}
