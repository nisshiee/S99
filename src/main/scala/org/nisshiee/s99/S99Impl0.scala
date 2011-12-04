package org.nisshiee.s99

trait S99Impl0 extends S99 {
  def last[A](list: List[A]): A =
    list match {
      case Nil => throw new Exception
      case e :: Nil => e
      case _ :: tail => last(tail)
    }

  def penultimate[A](list: List[A]): A =
    list match {
      case Nil => throw new Exception
      case _ :: Nil => throw new Exception
      case e :: _ :: Nil => e
      case _ :: tail => penultimate(tail)
    }

  def nth[A](n: Int, list: List[A]): A = {
    (n, list) match {
      case (_, Nil) => throw new Exception
      case (0, e :: _) => e
      case (n, _ :: tail) => nth(n - 1, tail)
    }
  }

  def length[A](list: List[A]): Int =
    list.view
      .map { _ => 1 }
      .reduce(_ + _)

  def reverse[A](list: List[A]): List[A] = {
    def reverserec(src: List[A], dst: List[A]): List[A] =
      src match {
        case Nil => dst
        case h :: t => reverserec(t, h :: dst)
      }
    reverserec(list, Nil)
  }

  def isPalindrome[A](list: List[A]): Boolean =
    list == reverse(list)

  def flatten(list: List[Any]): List[Any] =
    list match {
      case Nil => Nil
      case (h: List[Any]) :: tail => flatten(h) ++ flatten(tail)
      case h :: tail => h :: flatten(tail)
    }

  def compress[A](list: List[A]): List[A] =
    list match {
      case Nil => Nil
      case h :: Nil => List(h)
      case h1 :: h2 :: tail if (h1 == h2) => compress(h2 :: tail)
      case h :: tail => h :: compress(tail)
    }

  def pack[A](list: List[A]): List[List[A]] = {
    def headPack(src: List[A], dst: List[A]): (List[A], List[A]) =
      src match {
        case Nil => (Nil, dst)
        case h1 :: h2 :: tail if (h1 == h2) => headPack(h2 :: tail, h1 :: dst)
        case h :: tail => (tail, h :: dst)
      }

    list match {
      case Nil => Nil
      case list => {
        val (rest, head) = headPack(list, Nil)
        head :: pack(rest)
      }
    }
  }
}