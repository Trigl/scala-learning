package ink.baixin.scalalearning.implicits

object SendLove extends App {
  class RemoteLover extends Lover {}

  val lover: Lover = new RemoteLover

  // without implicit
  lover.sendLove(
    new Love {
      val event = Event("Valentine is coming!")

      def takeAction(event: Event) = {
        println("Buy a gift!")
      }
    }
  )

  // with implicit
  import Lover.function2Love

  lover.sendLove(
    (_: Event) => println("Give a hug!")
  )

  // explicit transform
  lover.sendLove(
    function2Love(
      (_: Event) => println("Give a hug!")
    )
  )
}