package ink.baixin.scalalearning.sbt

object Hello extends App {
  val p = Person("Ink Bai")
  println("Hello from " + p.name)
}

case class Person(var name: String)