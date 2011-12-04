package org.nisshiee.s99

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
}