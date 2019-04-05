package week_parallel.week1

package object SC_Book {

  def log(message: String) = println(s"${Thread.currentThread.getName} $message")

  def thread(body: => Unit): Thread = {
    val t = new Thread {
      override def run() = body
    }
    t.start()
    t
  }

}
