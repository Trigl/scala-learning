package ink.baixin.scalalearning
package implicits

object ImplicitClassTest {
  import utils.StringUtils.StringImprovements

  def main(args: Array[String]): Unit = {
    println("HAL".increment)
  }
}