name := "scala-learning"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "io.netty" % "netty-all" % "4.1.25.Final",
  "com.github.scopt" %% "scopt" % "3.7.0",
  "org.apache.calcite" % "calcite-core" % "1.16.0",
  "org.scalatest" %% "scalatest" % "3.0.5" % Test
)

lazy val subproject1 = (project in file("subproject1"))

lazy val subproject2 = (project in file("subproject2")).dependsOn(subproject1)

// aggregate: running a task on the aggregate project will also run it on the aggregated projects.
// dependsOn: a project depends on code in another project.
// without dependsOn, you'll get a compiler error: "object bar is not a member of package
// com.alvinalexander".
lazy val root = (project in file("."))
  .aggregate(subproject1, subproject2)
  .dependsOn(subproject1, subproject2)

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)