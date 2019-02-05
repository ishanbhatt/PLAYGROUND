package week_parallel.week1



class Account(var amount: Int = 0) {  // The contructor you were looking for

  val uid = java.util.UUID.randomUUID().getMostSignificantBits()
  def lockAndTransfer(target: Account, n: Int) =
    this.synchronized {
      target.synchronized {
        this.amount -= n
        target.amount += n
      }
    }

  def transfer(target: Account, n: Int) =
    if (this.uid < target.uid) this.lockAndTransfer(target, n)
    else target.lockAndTransfer(this, -n)

}


