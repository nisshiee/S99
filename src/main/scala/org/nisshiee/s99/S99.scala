package org.nisshiee.s99

import scalaz._
import Scalaz._

trait S99 {
  /**
   * P01 (*) Find the last element of a list.
   * @param list
   * @return
   */
  def last[A](list: List[A]): A

  /**
   * P02 (*) Find the last but one element of a list.
   * @param list
   * @return
   */
  def penultimate[A](list: List[A]): A

  /**
   * P03 (*) Find the Kth element of a list.
   *
   * By convention, the first element in the list is element 0.
   * @param n
   * @param list
   * @return
   */
  def nth[A](n: Int, list: List[A]): A

  /**
   * P04 (*) Find the number of elements of a list.
   * @param list
   * @return
   */
  def length[A](list: List[A]): Int

  /**
   * P05 (*) Reverse a list.
   * @param list
   * @return
   */
  def reverse[A](list: List[A]): List[A]

  /**
   * P06 (*) Find out whether a list is a palindrome.
   * @param list
   * @return
   */
  def isPalindrome[A](list: List[A]): Boolean

  /**
   * P07 (**) Flatten a nested list structure.
   * @param list
   * @return
   */
  def flatten(list: List[Any]): List[Any]

  /**
   * P08 (**) Eliminate consecutive duplicates of list elements.
   *
   * If a list contains repeated elements they should be replaced with a single copy of the element.
   * The order of the elements should not be changed.
   * @param list
   * @return
   */
  def compress[A](list: List[A]): List[A]

  /**
   * P09 (**) Pack consecutive duplicates of list elements into sublists.
   *
   * If a list contains repeated elements they should be placed in separate sublists.
   * @param list
   * @return
   */
  def pack[A](list: List[A]): List[List[A]]

  /**
   * P10 (*) Run-length encoding of a list.
   *
   * Use the result of problem P09 to implement the so-called run-length encoding data compression method.
   * Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
   * @param list
   * @return
   */
  def encode[A](list: List[A]): List[(Int, A)]

  /**
   * P11 (*) Modified run-length encoding.
   *
   * Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list.
   * Only elements with duplicates are transferred as (N, E) terms.
   * @param list
   * @return
   */
  def encodeModified[A](list: List[A]): List[Any]

  /**
   * P12 (**) Decode a run-length encoded list.
   *
   * Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
   * @param list
   * @return
   */
  def decode[A](list: List[(Int, A)]): List[A]

  /**
   * P13 (**) Run-length encoding of a list (direct solution).
   *
   * Implement the so-called run-length encoding data compression method directly.
   * I.e. don't use other methods you've written (like P09's pack); do all the work directly.
   * @param list
   * @return
   */
  def encodeDirect[A: Equal](list: List[A]): List[(Int, A)]

  /**
   * P14 (*) Duplicate the elements of a list.
   * @param list
   * @return
   */
  def duplicate[A](list: List[A]): List[A]

  /**
   * P15 (**) Duplicate the elements of a list a given number of times.
   * @param n
   * @param list
   * @return
   */
  def duplicateN[A](n: Int, list: List[A]): List[A]

  /**
   * P16 (**) Drop every Nth element from a list.
   * @param n
   * @param list
   * @return
   */
  def drop[A](n: Int, list: List[A]): List[A]

  /**
   * P17 (*) Split a list into two parts.
   *
   * The length of the first part is given. Use a Tuple for your result.
   * @param n
   * @param list
   * @return
   */
  def split[A](n: Int, list: List[A]): (List[A], List[A])

  /**
   * P18 (**) Extract a slice from a list.
   * @param s
   * @param e
   * @param list
   * @return
   */
  def slice[A](s: Int, e: Int, list: List[A]): List[A]

  /**
   * P19 (**) Rotate a list N places to the left.
   * @param n
   * @param list
   * @return
   */
  def rotate[A](n: Int, list: List[A]): List[A]

  /**
   * P20 (*) Remove the Kth element from a list.
   * @param k
   * @param list
   * @return
   */
  def removeAt[A](k: Int, list: List[A]): (List[A], A)
}
