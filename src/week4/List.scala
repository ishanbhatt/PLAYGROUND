package week4

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T,val tail: List[T]) extends List[T]{

  override def isEmpty: Boolean = false
  // As you can see it is not complaining about head and tail method
  // They are already implemented as value parameter
  // That's the power of scala
  // val head: T is legal implementation of def head: T os List[T]
}