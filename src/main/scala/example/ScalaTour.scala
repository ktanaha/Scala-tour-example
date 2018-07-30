package example

object ScalaTour {

  object Polygon {

    def fromEdges(edges: List[Int]): Option[Polygon] =
      edges.length match {
        case 3 => Some(new Triangle(edges))
        case x => None
      }
  }

  abstract class Polygon(edges: List[Int]) {
    val n = edges.size
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
    val invalidEdges2 = List(3, 4)
    val invalidPolygon2 = Polygon.fromEdges(invalidEdges2)

    println(invalidPolygon2)

    val invalidEdges3 = List(3, 4, 5)
    val invalidPolygon3 = Polygon.fromEdges(invalidEdges3)

    println(invalidPolygon3)
  }

}

object FizzBuzz {

  def toFizzBuzz(numbers: List[Int]): List[String] = {
    val f: Int => String = (i: Int) => i match {
      case x if x % 15 == 0 => "FizzBuzz"
      case x if x % 3 == 0 => "Fizz"
      case x if x % 5 == 0 => "Buzz"
      case x => x.toString
    }

    numbers.map(f)
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
