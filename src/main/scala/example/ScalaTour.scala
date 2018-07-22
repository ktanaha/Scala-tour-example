package example

object ScalaTour {

  abstract class Polygon(edges: List[Int]) {
    val n = edges.length
    val area: Double
  }

  class Triangle(edges: List[Int]) extends Polygon(edges) {
    val a = edges(0)
    val b = edges(1)
    val c = edges(2)

    val area = {
      val s = (a + b + c) / 2.0
      math.sqrt(s * (s - a) * (s - b) * (s - c))
    }
  }

  def main(args: Array[String]): Unit = {
    val edges = List(3, 4, 5)
    val triangle = new Triangle(edges)
    println(triangle.area)
  }

  def fizzBuzz(n: Int, i: Int = 1): Unit = {
    i match {
      case x if x % 15 == 0 =>
        println("FizzBuzz")
      case x if x % 5 == 0 =>
        println("Buzz")
      case x if x % 3 == 0 =>
        println("Fizz")
      case x =>
        println(x)
    }

    if (i < n) fizzBuzz(n, i + 1)
  }

  def fib(n: Int): Int = {
    @scala.annotation.tailrec
    def go(n: Int, prev: Int, curr: Int): Int =
      if (n == 0) prev
      else go (n - 1, curr, prev + curr)
    
    go(n, 0 ,1)
  }
}