package week4

import java.util.NoSuchElementException

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

class Nil[T] extends List[T]{
  override def isEmpty: Boolean = true

  // Nothing is a subtype of any other type including T
  override def head: Nothing = throw new NoSuchElementException

  override def tail: Nothing= throw new NoSuchElementException

}

// Functions cn also have type parameters
// def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
// singleton[Int](1) OR singleton(1)
// singleton[Boolean](true) OR singleton(true)
// Type parameters are there at compile time only
// You know it is type erasure