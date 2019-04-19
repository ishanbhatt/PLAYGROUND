package week_parallel.week1.SC_Book.ch3.Examples

import week_parallel.week1.SC_Book.ch3.{execute, log}

object ExecutionContextSleep extends App {

  for (i <- 0 until 32) execute {
    Thread.sleep(2000)
    log(s"Task $i completed")
  }

  Thread.sleep(10000)
}
