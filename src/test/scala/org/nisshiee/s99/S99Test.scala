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

  describe("P11") {
    it("should find Modified run-length encoding") {
      val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      val expected: List[Any] = List((4, 'a), 'b, (2, 'c), (2, 'a), 'd, (4, 'e))
      answer.encodeModified(list) should be(expected)
    }
  }

  describe("P12") {
    it("should decode a run-length encoded list") {
      val list = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
      val expected = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      answer.decode(list) should be(expected)
    }
  }

  describe("P13") {
    it("should find Run-length encoding of a list directly") {
      val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      val expected = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
      answer.encode(list) should be(expected)
    }
  }

  describe("P14") {
    it("should duplicate the elements of a list") {
      val list = List('a, 'b, 'c, 'c, 'd)
      val expected = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
      answer.duplicate(list) should be(expected)
    }
  }

  describe("P15") {
    it("should duplicate the elements of a list a given number of times") {
      val list = List('a, 'b, 'c, 'c, 'd)
      val expected = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
      answer.duplicateN(3, list) should be(expected)
    }
  }

  describe("P16") {
    it("should drop every Nth element from a list") {
      val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
      val expected = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
      answer.drop(3, list) should be(expected)
    }
  }

  describe("P17") {
    it("should split a list into two parts") {
      val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
      val expected = (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
      answer.split(3, list) should be(expected)
    }
  }

  describe("P18") {
    it("should extract a slice from a list") {
      val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
      val expected = List('d, 'e, 'f, 'g)
      answer.slice(3, 7, list) should be(expected)
    }
  }

  describe("P19") {
    it("should rotate a list N places to the left") {
      val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

      val expected1 = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
      answer.rotate(3, list) should be(expected1)

      val expected2 = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
      answer.rotate(-2, list) should be(expected2)
    }
  }
}