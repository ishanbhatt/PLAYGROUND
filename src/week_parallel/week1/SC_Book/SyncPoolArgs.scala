package week_parallel.week1.SC_Book

import scala.collection.mutable

object SyncPoolArgs extends App {
  private val tasks = mutable.Queue[() => Unit]()
  object Worker extends Thread {
    setDaemon(true)
    def poll() = tasks.synchronized {
      while (tasks.isEmpty) tasks.wait()
      tasks.dequeue()
    }
    override def run() = while (true) {
      val task = poll()
      task()
    }
  }
  Worker.start()
  def asynchronous(body: =>Unit) = tasks.synchronized {
    tasks.enqueue(() => body)
    tasks.notify()
  }

  def sum(x: Int, y:Int) = {println("USING SUM")
    x+y}

  asynchronous { log("Hello ") }
  asynchronous { log("World!") }
  asynchronous { sum(4,5) }
  Thread.sleep(500)
}