val scala3Version = "3.2.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "t-proj",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    //libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test
    //libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "3.0.0"
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "0.7.29" % Test,
      "org.scala-lang.modules" %% "scala-swing" % "3.0.0",
      "jline" % "jline" % "2.14.2",
      //"jline" % "jline" % "3.21.0"
    )

  )
