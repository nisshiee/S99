package org.nisshiee.s99

import scalaz._
import Scalaz._

trait S99Impl2 extends S99 {
  def removeAt[A](k: Int, list: List[A]): (List[A], A) =
    (k, list) match {
      case (_, Nil) => throw new IllegalArgumentException
      case (0, h :: t) => (t, h)
      case (k, h :: t) => {
        val (tail, elem) = removeAt(k - 1, t)
        (h :: tail, elem)
      }
    }
}
