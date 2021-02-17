ThisBuild / scalaVersion     := "2.13.4"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "org.kindofdev.zionomicon"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "zionomicon-exercises",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % "1.0.4-2",
      "dev.zio" %% "zio-test" % "1.0.4-2" % Test
    ),
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
  )
