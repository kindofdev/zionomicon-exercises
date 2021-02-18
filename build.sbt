ThisBuild / scalaVersion := "2.13.4"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "org.kindofdev.zionomicon"
ThisBuild / organizationName := "example"

val zioVersion = "1.0.4-2"

lazy val root = (project in file("."))
  .settings(
    name := "zionomicon-exercises",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % zioVersion,
      "dev.zio" %% "zio-test" % zioVersion,
      "dev.zio" %% "zio-test-sbt" % zioVersion
    ),
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
  )
