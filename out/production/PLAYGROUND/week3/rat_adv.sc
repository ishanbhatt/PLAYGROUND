object rat_adv{
  val x = new Rational(1,2)
  val y = new Rational(1,3)
  val z = new Rational(3,7)
  // You can call function in below manner too
  // Without using . operator
  // x max z is called infix notation
  z < x
  x max z
  // As above the operator overloading is super easy
  // See below too
  x + z
  z - y
  /*
  * In this operator space you may wonder about precedence
  * But as it turns out for the overloaded operators
  * precedence is same as normal ones BODMAS
  * */

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

  def + (that: Rational) = {
    new Rational(that.numer*denom + that.denom*numer, that.denom*denom)
  }

  // Issue with neg is that neg is a unary operator
  // -that should not be using  def - as their purpose differ
  // To overcome scala gives you unary_ operator specifier
  def unary_- = new Rational(-numer, denom)

  def - (that: Rational) = this + -that

  def mul(that: Rational) = {
    new Rational(that.numer*numer, that.denom*denom)
  }

  def inv= new Rational(denom, numer)

  def div(that: Rational) = {
    mul(that.inv)
  }

  // < is a valid identifier in scala
  def < (that: Rational) = numer*that.denom < denom*that.numer

  def max(that: Rational) = if (this < that) that else this
  // To use less, we need the whole rational number, not parts(denom,numer)
  // For that we can use this, object on which the current method is executed

  // If you are defining val,def inside the function {} becomes MANDATORY
  override def toString: String = {
    val g = gcd(x, y)
    this.numer / g + "/" + this.denom / g
  }
}