package week_parallel.week1.SC_Book

object ThreadsNondeterminism extends App{
  val t = thread(log("New Thread Running"))
  log("...")
  log("...")
  t.join()
  log("New thread joined")
}
