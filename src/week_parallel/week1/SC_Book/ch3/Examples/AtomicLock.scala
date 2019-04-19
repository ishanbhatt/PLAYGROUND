package week_parallel.week1.SC_Book.ch3.Examples

import java.util.concurrent.atomic.AtomicBoolean

import week_parallel.week1.SC_Book.ch3.{execute, log}

object AtomicLock extends App{
  private var lock = new AtomicBoolean(false)

  def mySync(body: => Unit) = {
    while (! lock.compareAndSet(false, true)) {}
    try body finally lock.set(false)
  }
  var count = 0
  for(i <- 1 to 10) execute{ mySync { count += 1}}
  Thread.sleep(1000)
  log(s" Count is $count")

}

/** The above attempt to build lockfree construct is heavily flawed
  * In case of normal sync all other threads would be in WAITING state
  * Here it is much worse, all the threads are in busy wait because of infinite while loop
  * So, lock free mechanism is bound to fail here
  * */
