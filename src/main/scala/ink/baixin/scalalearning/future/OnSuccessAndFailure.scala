package ink.baixin.scalalearning.future

import scala.concurrent.Future
import scala.util.Random
import scala.concurrent.ExecutionContext.Implicits.global

object OnSuccessAndFailure extends App {

  val f = Future {
    val timeout = Random.nextInt(500)
    sleep(timeout)
    if (timeout > 250) throw new Exception("Yikes!") else 42
  }

  f onSuccess {
    case result => println(s"Success: $result")
  }

  f onFailure {
    case t => println(s"Failure: ${t.getMessage}")
  }

  // do the rest of your work
  println("A ..."); sleep(100)
  println("B ..."); sleep(100)
  println("C ..."); sleep(100)
  println("D ..."); sleep(100)
  println("E ..."); sleep(100)
  println("F ..."); sleep(100)
}
