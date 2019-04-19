package week_parallel.week1.SC_Book

// This example explains use of volatile variables to achieve thread communication.
// Onee thread will set the volatile var on some condition and other threads would stop by checking that cond

/*Reads and writes to variables marked as volatile are never reordered. If a write W to a
volatile v variable is observed on another thread through a read R of the same variable,
then all the writes that preceded the write W are guaranteed to be observed after the
read R.
*/

class Page(val txt: String, var position: Int)

object Volatile extends App{
  val pages = for (i<- 1 to 5) yield
    new Page("Na" * (100 - 20 * i) + " Batman!", -1)

  @volatile var found = false

  for (p <- pages) yield thread{
    var i = 0
    while (i < p.txt.length && !found)
      if (p.txt(i) == '!') {
        p.position = i
        found = true
      } else i+=1
  }

  // Write to position is done b4 write to found, which in turn is before read found in line below
  // So, main thread always sees the write of the thread that set found
  while (!found) {}  // This is busy wait, we can also use as a construct for infinite loop
  log(s"results: ${pages.map(_.position)}")  //

}
