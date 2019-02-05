package week_parallel.week1

object AccRunnerDeadLocked {
  // The below method is critical, it simulates parallel transaction
  // It will keep on transferring $1 in a loop, and we will start two such threads
  // After finishing both the amount should remain the same

  def startThread(a: Account, b: Account, n: Int) = {
    val t = new Thread {
      override def run(): Unit = {
        for (i <- 0 until n) {
          a.transfer(b, 1)
        }
      }
    }
    t.start()
    t  // Looks like a pattern in scala, to start a thread and return it so that you can do join and etc
       // To Avoid that you can create a class that extend Thread and override run method
       // Create an object of class and do standard t.start(), t.join(),
  }

  def main(args: Array[String]): Unit = {

    val a1 = new Account(500000)
    val a2 = new Account(700000)

    val t = startThread(a1, a2, 150000)
    val s = startThread(a2, a1, 150000)

    // a1's transfer got lock on a1 object is waiting for lock on a2 object
    // a2's transfer got lock on a2 object is waiting for lock on a1 object

    t.join()
    s.join()

    println(a1.amount)
    println(a2.amount)

  }
}
