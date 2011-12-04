package org.nisshiee.s99
import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

trait S99Test extends Spec with ShouldMatchers {
  def answer: S99

  describe("P01") {
    it("should find the last element of a list") {
      answer.last(List(1, 1, 2, 3, 5, 8)) should be(8)
    }
  }

  describe("P02") {
    it("should find the last but one element of a list") {
      answer.penultimate(List(1, 1, 2, 3, 5, 8)) should be(5)
    }
  }

  describe("P03") {
    it("should find the Kth element of a list") {
      answer.nth(2, List(1, 1, 2, 3, 5, 8)) should be(2)
    }
  }

  describe("P04") {
    it("should find the number of elements of a list") {
      answer.length(List(1, 1, 2, 3, 5, 8)) should be(6)
    }
  }

  describe("P05") {
    it("should reverse a list") {
      answer.reverse(List(1, 1, 2, 3, 5, 8)) should be(List(8, 5, 3, 2, 1, 1))
    }
  }

  describe("P06") {
    it("should find out whether a list is a palindrome") {
      answer.isPalindrome(List(1, 2, 3, 2, 1)) should be(true)
    }
  }

  describe("P07") {
    it("should flatten a nested list structure") {
      answer.flatten(List(List(1, 1), 2, List(3, List(5, 8)))) should be(List(1, 1, 2, 3, 5, 8))
    }
  }

  describe("P08") {
    it("should eliminate consecutive duplicates of list elements") {
      val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      answer.compress(list) should be(List('a, 'b, 'c, 'a, 'd, 'e))
    }
  }

  describe("P09") {
    it("should pack consecutive duplicates of list elements into sublists") {
      val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      val expected = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
      answer.pack(list) should be(expected)
    }
  }

  describe("P10") {
    it("should find Run-length encoding of a list") {
      val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      val expected = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
      answer.encode(list) should be(expected)
    }
  }
}