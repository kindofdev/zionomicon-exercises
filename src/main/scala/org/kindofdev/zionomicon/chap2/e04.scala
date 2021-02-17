package org.kindofdev.zionomicon.chap2

import zio.ZIO

/**
 * Rewrite the following ZIO code that uses flatMap into a for comprehension
 */
object e04 {
  def printLine(line: String) = ZIO.effect(println(line))
  val readLine = ZIO.effect(scala.io.StdIn.readLine())

  printLine("What is your name?").flatMap(_ => readLine.flatMap(name => printLine(s"Hello, $name!")))

  for {
    _ <- printLine("What is your name?")
    name <- readLine
    _ <- printLine(s"Hello, $name!")
  } yield ()

}
