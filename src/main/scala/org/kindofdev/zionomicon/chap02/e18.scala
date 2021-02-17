package org.kindofdev.zionomicon.chap02

import zio.{App => ZIOApp, _}

import java.io.IOException

/**
 * Using the Console and Random services in ZIO, write a little program that
asks the user to guess a randomly chosen number between 1 and 3, and
prints out if they were correct or not.
 */
object NumberGuessing extends ZIOApp {

  import zio.console._
  import zio.random._

  val program: ZIO[Console with Random, IOException, Unit] = for {
    n <- nextIntBetween(1, 4)
    _ <- putStrLn("Guess a number from 1 to 3")
    number <- getStrLn
    _ <- checkNumber(n.toString, number)
  } yield ()

  private def checkNumber(n: String, number: String) =
    if (n == number)
      putStrLn("You are lucky!")
    else
      putStrLn("Try again")

  def run(args: List[String]) = program.exitCode
}
