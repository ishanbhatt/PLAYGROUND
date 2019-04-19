package week_parallel.week1.SC_Book.ch3.Examples

import java.util.concurrent.atomic._

import week_parallel.week1.SC_Book.ch3.{execute, log}

object AtomicUid extends App {
  private val uid = new AtomicLong(0L)
  def getUniqueId = uid.incrementAndGet()
  /* This is a true lock-free construct
    Compare and swap handles the trickery for you
  * */
  execute( log(s"Uid async : ${getUniqueId}"))
  log(s"Uid MAIN : ${getUniqueId}")
}
