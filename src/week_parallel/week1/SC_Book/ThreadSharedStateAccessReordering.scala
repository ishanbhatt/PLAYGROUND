package week_parallel.week1.SC_Book

object ThreadSharedStateAccessReordering extends App{

  for (i <- 0 until 10000){
    var a = false
    var b = false
    var x = -1
    var y = -1

    val t1 = thread {
      this.synchronized {
        a = true
        y = if (b) 0 else 1
      }
    }

    val t2 = thread {
      this.synchronized {
        b = true
        x = if (a) 0 else 1
      }
    }

    t1.join()
    t2.join()

    assert(!(x == 1 && y == 1), s"x = $x, y = $y")
  }

}
/* THE ABOVE CODE WAS WITHOUT SYNCRONIZED
* The error we made when
analyzing the example is that we assumed that the writes by one thread are immediately
visible to all the other threads. We always need to apply proper synchronization to ensure
that the writes by one thread are visible to another thread.
* */
