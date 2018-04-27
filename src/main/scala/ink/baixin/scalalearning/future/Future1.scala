package ink.baixin.scalalearning.future

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object Future1 extends App {
  implicit val baseTime = System.currentTimeMillis

  val f = Future {
    sleep(500)
    1 + 1
  }

  val result = Await.result(f, 1 second)
  println(result)

}
