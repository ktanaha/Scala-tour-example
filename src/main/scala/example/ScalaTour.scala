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

  trait Color {
    val red: Int
    val green: Int
    val blue: Int
    
    def printColor(): Unit = println(s"$red-$green-$blue")
  }

  trait Blue extends Color {
    override val red = 0
    override val green = 0
    override val blue = 255
  }

 trait Yellow extends Color {
    override val red = 255
    override val green = 255
    override val blue = 0
  }

  trait Transparency {
    val alpha: Double
  }
  
  trait Frosted extends Transparency {
    override val alpha = 0.5
  }

  class BlueFrostedTriangle(edges: List[Int])
      extends Polygon(edges) with Blue with Frosted {
    val a = edges(0)
    val b = edges(1)
    val c = edges(2)

    val area = {
      val s = (a + b + c) / 2.0
      math.sqrt(s * (s - a) * (s - b) * (s - c))
    }
  }

  def main(args: Array[String]): Unit = {
    val n = 15
    val numbers = (1 to n).toList
    val fizzBuzzList = toFizzBuzz(numbers)
    fizzBuzzList.foreach(s => println(s))
  }

  def toFizzBuzz(numbers: List[Int]): List[String] =
    numbers.map((i: Int) => i match {
      case x if x % 15 == 0 => "FizzBuzz"
      case x if x % 3 == 0 => "Fizz"
      case x if x % 5 == 0 => "Buzz"
      case x => x.toString
    })

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