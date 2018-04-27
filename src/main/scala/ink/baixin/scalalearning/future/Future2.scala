package ink.baixin.scalalearning.future

import scala.concurrent.Future
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

object Future2 extends App {

  def longRunningComputation(i: Int): Future[Int] = Future {
    sleep(100)
    i + 1
  }

  longRunningComputation(11).onComplete {
    case Success(result) => println(s"result = $result")
    case Failure(e) => e.printStackTrace
  }

  // keep the jvm from shutting down
  sleep(1000)
}
