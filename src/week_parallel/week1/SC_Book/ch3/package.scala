package week_parallel.week1.SC_Book

import scala.concurrent.ExecutionContext

package object ch3 {

  def log(message: String) = println(s"${Thread.currentThread.getName} $message")

  def thread(body: => Unit) = {
    val t = new Thread{
      override def run(): Unit = body
    }
    t.start()
    t
  }

  // Hope you understand that the below is taking an anonymous inner class
  def execute(body: => Unit) = ExecutionContext.global.execute(
    new Runnable {
      override def run(): Unit = body
    }
  )

}
