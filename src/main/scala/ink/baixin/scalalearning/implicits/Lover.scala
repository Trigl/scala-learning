package ink.baixin.scalalearning
package implicits

trait Lover {
  def sendLove(love: Love) {}
}

trait Love {
  val event: Event

  val show = takeAction(event)

  def takeAction(event: Event)
}

case class Event(str: String)


object Lover {
  implicit def function2Love(f: Event => Unit) = new Love {
    val event = Event("Valentine is coming!")

    def takeAction(event: Event): Unit = f(event)
  }
}



