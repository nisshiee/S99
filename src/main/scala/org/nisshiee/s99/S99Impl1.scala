package org.nisshiee.s99

trait S99Impl1 extends S99 with S99Impl0 {
  def encode[A](list: List[A]): List[(Int, A)] = {
    pack(list).map(list => (length(list), list.head))
  }
}