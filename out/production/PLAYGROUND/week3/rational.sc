object rational{
  val x = new Rational(1,2)
  val y = new Rational(1,3)
  val ans = x.sub(y)
  ans
  ans.inv
  x.div(x)
  y.less(x)


}

class Rational(x: Int, y: Int) {

  // assert of python, throws IllegalArgument exceeption
  // assert is there also, similar
  // require is used to enforce a precondition on the caller of function
  // assert is used to check the code of the function itself
  require(y!=0, "Denom must not be zero")

  // Multiple constructors, this function is constructor not the class name
  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a
    else gcd(b, a%b)
  }

  // private members, Just like Java
  // we calculate gcd immedietly so that it can be used to divide x,y
  val numer = x
  val denom = y
  // val are computed only once, unlike def
  // def would have been computed everytime it is called
  // You can assume it as cachedproperty,

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
  // To use less, we need the whole rational number, not parts(denom,numer)
  // For that we can use this, object on which the current method is executed

  // If you are defining val,def inside the function {} becomes MANDATORY
  override def toString: String = {
    val g = gcd(x, y)
    this.numer / g + "/" + this.denom / g
  }
}