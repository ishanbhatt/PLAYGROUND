package week_parallel.week1.SC_Book

object ThreadsUnprotectedUid extends App {
  var uidCount = 0L

  def getUniqueID = this.synchronized {
    val freshUid = uidCount + 1
    uidCount = freshUid
    freshUid
  }

  def printUniqueIds(n: Int): Unit = {
    val uids = for (i<- 0 until n) yield getUniqueID
    log(s" GENERATED UIDS : $uids")
  }

  val t = thread({printUniqueIds(5)})
  printUniqueIds(5)
  t.join()

}
