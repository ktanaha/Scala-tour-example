package example

import sbt.io.IO

import java.io.File

import org.scalatest.FlatSpec
import org.json4s.jackson.Serialization.{read, write}

class ScalaTourSpec extends FlatSpec {
  def createSourceJSONAndThenFizzBuzzFromJSON(n: Int): Unit = {

    implicit val formats = org.json4s.DefaultFormats
    val sourceFile = new File("sample.json")
    val destinationFile = new File("fizzBuzz.json")

    ScalaTour.createSourceJSON(n, sourceFile)
    ScalaTour.fizzBuzzFromJSON(sourceFile, destinationFile)

    val json = read[FizzBuzzHolder](IO.read(destinationFile))
    json.fizzBuzz.zipWithIndex.foreach(pair => {
      pair._2 + 1 match {
        case x if x % 15 == 0 => assert(pair._1 === "FizzBuzz")
        case x if x % 5 == 0 => assert(pair._1 === "Buzz")
        case x if x % 3 == 0 => assert(pair._1 === "Fizz")
        case x => assert(pair._1 === x.toString)
      }
    })
  }

  s"'createSourceJSON' & 'fizzBuzzFromJSON' (1 to 0)" should
    "throw IllegalArgumentException" in {
    assertThrows[IllegalArgumentException] {
      createSourceJSONAndThenFizzBuzzFromJSON(0)
    }
  }

  for { n <- Array(1, 15, 100)} {
    s"'createSourceJSON' & 'fizzBuzzFromJSON' (1 to $n" should
      "apply FizzBuzz to data from JSON file" in {
        createSourceJSONAndThenFizzBuzzFromJSON(0)
    }
  }

  s"'createSourceJSON' & 'fizzBuzzFromJSON' (1 to 0)" should
    "apply FizzBuzz to data from JSON file" in {
      createSourceJSONAndThenFizzBuzzFromJSON(0)
  }
}
