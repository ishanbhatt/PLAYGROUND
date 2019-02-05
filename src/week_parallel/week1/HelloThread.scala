package week_parallel.week1


object HelloThread {

  private var uidCount = 0L
  private val x = new AnyRef  // You need syncronized block
  // Code block after a syncronized call on an object x is never executed by two threads at the same time
  // This method is syncronized on object x

  def getUniqueId() = x.synchronized {
    uidCount += 1
    uidCount
  }

  def startThread() ={
    val t = new Thread { // Anon class
      override def run(): Unit = {
        val uids = for (i <- 0 until 10) yield getUniqueId()
        println(uids)
      }
    }
    t.start()
    t
  }

  def main(args: Array[String]): Unit = {
    startThread()
    startThread()

  }

}
