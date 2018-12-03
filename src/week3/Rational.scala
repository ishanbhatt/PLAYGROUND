package week3

class Rational(x: Int, y: Int) {

  require(y!=0, "Denom must not be zero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a
    else gcd(b, a%b)
  }

  val numer = x
  val denom = y

  def add(that: Rational) = {
    new Rational(that.numer*denom + that.denom*numer, that.denom*denom)
  }

  def neg = new Rational(-numer, denom)

  def sub(that: Rational) = {
    add(that.neg)
  }

  def mul(that: Rational) = {
    new Rational(that.numer*numer, that.denom*denom)
  }

  def inv= new Rational(denom, numer)

  def div(that: Rational) = {
    mul(that.inv)
  }

  def less(that: Rational) = numer*that.denom < denom*that.numer

  def max(that: Rational) = if (this.less(that)) that else this

  override def toString: String = {
    val g = gcd(x, y)
    this.numer / g + "/" + this.denom / g
  }
}