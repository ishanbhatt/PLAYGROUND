package week_parallel.week1.SC_Book

object ThreadsCommunicate extends App {
  var result: String = null
  val t = thread {result = "Something else"}

  t.join()
  log(result)
}
