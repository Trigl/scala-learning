package ink.baixin.scalalearning.example

class Animal {
  def behavior = println("eee")
}

class Cat extends Animal {
  override def behavior: Unit = println("miao~")
}

object AnimalTest {
  def main(args: Array[String]): Unit = {
    val dog = new Animal {
      override def behavior: Unit = println("wang!")
    }
    dog.behavior

    val cat = new Cat
    cat.behavior
  }
}