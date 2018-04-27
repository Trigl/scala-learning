package ink.baixin.scalalearning.future

import scala.concurrent.Future
import scala.util.{Failure, Random, Success}
import scala.concurrent.ExecutionContext.Implicits.global

object RunningMultipleCalls extends App {

  println("starting futures")
  val result1 = Cloud.runAlgorithm(10)
  val result2 = Cloud.runAlgorithm(20)
  val result3 = Cloud.runAlgorithm(30)

  println("before for-comprehension")
  val result = for {
    r1 <- result1
    r2 <- result2
    r3 <- result3
  } yield (r1 + r2 + r3)

  println("before onComplete")
  result onComplete {
    case Success(result) => println(s"total = $result")
    case Failure(e) => e.printStackTrace
  }

  println("before sleep at the end")
  sleep(2000)

}

object Cloud {
  def runAlgorithm(i: Int): Future[Int] = Future {
    sleep(Random.nextInt(500))
    val result = i + 10
    println(s"returning result from cloud: $result")
    result
  }
}
