package ink.baixin.scalalearning.implicits


object SendLove extends App {

  import Lover.function2LoveHeart

  class RemoteLover extends Lover {}

  val lover = new RemoteLover

  // without implicit
  lover.sendLoveHeart(
    new LoveHeart {
      val event = Event("Valentine is coming!")

      def takeAction(event: Event) = {
        println("Buy a gift!")
      }
    }
  )

  // with implicit
  lover.sendLoveHeart(
    (_: Event) => println("Give a hug!")
  )

}
