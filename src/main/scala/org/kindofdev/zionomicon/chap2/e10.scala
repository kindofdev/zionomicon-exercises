package org.kindofdev.zionomicon.chap2

/**
 * Using the following code as a foundation, write a ZIO application that
 * prints out the contents of whatever files are passed into the program as
 * command-line arguments. You should use the functions readFileZio
 * and writeFileZio that you developed in these exercises, as well as
 * ZIO.foreach.
 */
object e10 {
  import e01._
  import zio.{ZIO, App => ZIOApp}

  object Cat extends ZIOApp {

    def run(commandLineArguments: List[String]) = {
      (for {
        contents <- ZIO.foreach(commandLineArguments)(file => readFileZio(file))
        _ <- ZIO.effect(println(contents))
      } yield ()).exitCode
    }
  }
 }
