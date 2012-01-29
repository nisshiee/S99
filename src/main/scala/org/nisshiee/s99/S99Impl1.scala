package org.nisshiee.s99

import scalaz._
import Scalaz._

trait S99Impl1 extends S99 with S99Impl0 {
  def encode[A](list: List[A]): List[(Int, A)] = {
    pack(list).map(list => (length(list), list.head))
  }

  def encodeModified[A](list: List[A]): List[Any] = {
    encode(list) map {
      case (1, a) => a
      case t => t
    }
  }

  def decode[A](list: List[(Int, A)]): List[A] =
    list >>= { case (n, a) => a.replicate[List](n) }

  def encodeDirect[A: Equal](list: List[A]): List[(Int, A)] =
    list match {
      case Nil => Nil
      case h :: _ => {
        val (pre, post) = list span { h === _ }
        (pre.length, h) :: encodeDirect(post)
      }
    }

  def duplicate[A](list: List[A]): List[A] =
    list >>= { _.replicate[List](2) }

  def duplicateN[A](n: Int, list: List[A]): List[A] =
    list >>= { _.replicate[List](n) }

  def drop[A](n: Int, list: List[A]): List[A] =
    for (
      (a, i) <- list.zipWithIndex if ((i + 1) % n /== 0)
    ) yield a

  def split[A](n: Int, list: List[A]): (List[A], List[A]) =
    (n, list) match {
      case (_, Nil) => (Nil, Nil)
      case (n, post) if (n <= 0) => (Nil, post)
      case (n, h :: tail) => {
        val (pre, post) = split(n - 1, tail)
        (h :: pre, post)
      }
    }

  def slice[A](s: Int, e: Int, list: List[A]): List[A] =
    split(e, list)._1 |> { split(s, _)._2 }

  def rotate[A](n: Int, list: List[A]): List[A] = {
    case class FlooredDivision(n: Int) { def %%(m: Int) = (n % m + m) % m }
    implicit def toFlooredDivision(n: Int) = FlooredDivision(n)
    val (pre, post) = split(n %% list.length, list)
    post |+| pre
  }
}