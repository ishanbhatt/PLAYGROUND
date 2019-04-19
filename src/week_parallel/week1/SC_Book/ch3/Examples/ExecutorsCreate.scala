package week_parallel.week1.SC_Book.ch3.Examples

import week_parallel.week1.SC_Book.ch3._
import java.util.concurrent.ForkJoinPool

object ExecutorsCreate extends App {
  val executor = new ForkJoinPool
  executor.execute(new Runnable {
    override def run(): Unit = log("This task runs async")
  })

  Thread.sleep(500)  // Needed otherwise main thread will complete before executor gets a chance to run
}
