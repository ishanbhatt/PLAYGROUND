import week3.Rational

//import week3._ imports everything from package

object scratch{

  // Strange but always run the .scala file
  // You need to compile before you import, obvious
  new Rational(1,2)

  def error(msg: String) = throw new Error(msg)
}