package week_parallel.week1.SC_Book

import scala.collection._
import ThreadsUnprotectedUid.getUniqueID

object SynchronizedNesting extends App{

  private val transfers = mutable.ArrayBuffer[String]()

  def logTransfer(name: String, n: Int) = transfers.synchronized{
    transfers += s"transfer to accout '$name' = $n"
  }

  class Account(val name: String, var money: Int) {
    val uid = getUniqueID // uid attribute directly gets added to the object, just like
  }

  def add(account: Account, n:Int) = account.synchronized {
    account.money += n
    if (n > 10) logTransfer(account.name, n)
  }

//  Below method suffers from deadlock
  def send(a: Account, b: Account, n: Int) = a.synchronized{
    b.synchronized{
      a.money -= n
      b.money += n
    }
  }

  def betterSend(a: Account, b: Account, n: Int) = {
    def adjust(): Unit = {
      a.money -= n
      b.money += n
    }

    if (a.uid < b.uid)
      a.synchronized { b.synchronized { adjust() }}
    else b.synchronized { a.synchronized {adjust() }}
  }

  val jane = new Account("Jane", 100)
  val john = new Account("John", 200)

  val t1 = thread { add(jane, 5)}
  val t2 = thread { add(john, 50)}
  val t3 = thread { add(jane, 70)}

  t1.join();t2.join();t3.join()
  log(s"$transfers")

//  Example running the send
  val jack = new Account("Jack", 1000)
  val jill = new Account("Jill", 2000)

  val t4 = thread{ for(i <- 0 until 100) betterSend(jack, jill, 1)}
  val t5 = thread{ for(i <- 0 until 100) betterSend(jill, jack, 1)}

  t4.join();t5.join()
  log(s"jack = ${jack.money} , jill = ${jill.money}")

}
