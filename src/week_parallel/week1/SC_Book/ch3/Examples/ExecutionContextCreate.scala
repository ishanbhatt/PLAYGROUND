package week_parallel.week1.SC_Book.ch3.Examples

import week_parallel.week1.SC_Book.ch3._

import scala.concurrent._


object ExecutionContextCreate extends App {
  val pool = new forkjoin.ForkJoinPool(2) // Two worker threads are available
  val ectx = ExecutionContext.fromExecutorService(pool)

  ectx.execute(new Runnable {
    override def run(): Unit = log("Running on execution context")
  })
  Thread.sleep(300)
}
