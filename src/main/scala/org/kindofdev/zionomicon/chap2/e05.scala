package org.kindofdev.zionomicon.chap2

import zio.ZIO

/**
 * Rewrite the following ZIO code that uses flatMap into a for comprehension
 */
object e05 {
  val random = ZIO.effect(scala.util.Random.nextInt(3) + 1)
  def printLine(line: String) = ZIO.effect(println(line))
  val readLine = ZIO.effect(scala.io.StdIn.readLine())

  random.flatMap(int =>
    printLine("Guess a number from 1 to 3:").flatMap(_ =>
      readLine.flatMap(num =>
        if (num == int.toString) printLine("You guessed right!")
        else printLine(s"You guessed wrong, the number was ${int}!")))
  )

  for {
    n <- random
    _ <- printLine("Guess a number from 1 to 3:")
    number <- readLine
    _ <- checkNumber(n.toString, number)
  } yield ()

  private def checkNumber(n: String, guessed: String): ZIO[Any, Throwable, Unit] =
    if (n == guessed)
      printLine("You guessed right!")
    else
      printLine(s"You guessed wrong, the number was $n!")

}
