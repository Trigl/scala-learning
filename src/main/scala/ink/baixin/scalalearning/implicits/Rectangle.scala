package ink.baixin.scalalearning.implicits

object Rectangle extends App {

  case class Rectangle(width: Int, height: Int)

  implicit class RectangleMaker(width: Int) {
    def x(height: Int) = Rectangle(width, height)
  }

  val myRectangle = 3 x 4
  println(myRectangle)
}
