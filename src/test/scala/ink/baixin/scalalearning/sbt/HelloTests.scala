package ink.baixin.scalalearning.sbt

import org.scalatest.FunSuite

class HelloTests extends FunSuite {
  test("the name is set correctly in constructor") {
    val p = Person("Ink Bai")
    assert(p.name == "Ink Bai")
  }

  test("a Person's name can be changed") {
    val p = Person("Will")
    p.name = "William"
    assert(p.name == "William")
  }
}
