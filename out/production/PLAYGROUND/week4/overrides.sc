object overrides{

}

abstract class Base {
  def foo = 1
  def bar : Int
}

class Sub extends Base{
  override def foo = 3  // Overrides the defined variable
  def bar = 4 // implements undefined variable,  Must be implemented

  // override def foobar = 78, Opposite protection is also there
}

object Sub1 extends Sub{
// It is singleton object named Sub1
  // You can not do Sub1 extends Base as base has bar un implemented
}