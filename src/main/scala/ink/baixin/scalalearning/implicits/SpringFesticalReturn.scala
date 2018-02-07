package ink.baixin.scalalearning.implicits

case class Remote(address: String)

case class Home(address: String)

object Transportation {
  def transport(name: String)(implicit remote: Remote, home: Home) = {
    println(s"To celebrate Spring Festival, go from $remote to $home, by $name.")
  }
}

object Address {
  implicit val remote = new Remote("Shanghai")
  implicit val home = new Home("Shanxi")
}