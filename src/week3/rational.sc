object rational{
  val x = new Rational(1,2)
  val ans = x.sub(new Rational(1,3))
  print(ans)
  print(ans.inv)
  print(x.div(x))

}

class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y

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
  override def toString: String = this.numer + "/" + this.denom
}