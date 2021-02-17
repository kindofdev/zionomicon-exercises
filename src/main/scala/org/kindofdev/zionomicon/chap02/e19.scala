package org.kindofdev.zionomicon.chap02

import zio.ZIO

/**
 * Using the Console service and recursion, write a function that will repeatedly read input
from the console until the specified user-defined function
evaluates to true on the input.
 */
object e19 extends zio.App {
  import zio.console._

  import java.io.IOException

  def readUntil(
      acceptInput: String => Boolean
  ): ZIO[Console, IOException, String] =
    for {
      _ <- putStrLn("Please, introduce foo")
      value <- getStrLn
      _ <- if (acceptInput(value)) putStrLn("Thank you!") else readUntil(acceptInput)
    } yield value

  val program = readUntil(_.equals("foo"))

  override def run(args: List[String]) = program.exitCode
}
