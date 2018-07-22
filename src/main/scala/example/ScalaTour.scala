package example

object ScalaTour {
  def main(args: Array[String]): Unit = {
    //fizzBuzz(100)
    println(fib(13))
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