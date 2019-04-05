package week_parallel.week1.SC_Book

object ThreadsCreation extends App {

  class MyThread extends Thread {
    override def run(): Unit = log("New Thread is Running")
  }

  val t = new MyThread
  t.start()
  t.join()
  log("DONE")

}
