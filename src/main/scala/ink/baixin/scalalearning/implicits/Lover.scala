package ink.baixin.scalalearning
package implicits


trait Lover {

  def sendLoveHeart(lh: LoveHeart) {}
}


trait LoveHeart {

  val event: Event

  val show = takeAction(event)

  def takeAction(event: Event)
}

case class Event(str: String)


object Lover {

  implicit def function2LoveHeart(f: Event => Unit) = new LoveHeart {

    def takeAction(event: Event): Unit = f(event)

    val event: Event = Event("Valentine is coming!")
  }
}



