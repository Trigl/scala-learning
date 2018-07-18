name := "scala-learning"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "io.netty" % "netty-all" % "4.1.25.Final",
  "com.github.scopt" %% "scopt" % "3.7.0"
)

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)