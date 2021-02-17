package org.kindofdev.zionomicon.chap2

/**
 * Using the Console, write a little program that asks the user what their
 * name is, and then prints it out to them with a greeting.
 */
import zio.{App => ZIOApp}

object HelloHuman extends ZIOApp {

  import zio.console._

  val program = for {
    _ <- putStrLn("What's your name?")
    name <- getStrLn
    _ <- putStrLn(s"Hi $name!")
  } yield ()

  def run(args: List[String]) = program.exitCode
}
