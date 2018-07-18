package ink.baixin.scalalearning.scopt

object ConfigOptionTest extends App {
  // parser.parse returns Option[C]
  ConfigOptionParser.parse(args, ConfigOption()) match {
    case Some(config) =>
      // do stuff
      println(config)
    case None =>
      // arguments are bad, error message will have been displayed
  }
}