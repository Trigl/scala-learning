package ink.baixin.scalalearning.control

object LabeledBreakDemo extends App {
  import scala.util.control._

  val Inner = new Breaks
  val Outer = new Breaks

  Outer.breakable {
    for (i <- 1 to 5) {
      Inner.breakable {
        for (j <- 'a' to 'e') {
          if (i == 1 && j == 'c') Inner.break() else println(s"i: $i, j: $j")
          if (i == 2 && j == 'b') Outer.break()
        }
      }
    }
  }
}
