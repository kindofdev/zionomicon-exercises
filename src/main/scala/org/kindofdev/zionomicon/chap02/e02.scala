package org.kindofdev.zionomicon.chap02

import zio.ZIO

/**
 * Implement a ZIO version of the function writeFile by using the ZIO.effect
 constructor.
 */
object e02 {

  def writeFile(file: String, text: String): Unit = {
    import java.io._
    val pw = new PrintWriter(new File(file))
    try pw.write(text)
    finally pw.close
  }

  def writeFileZio(file: String, text: String): ZIO[Any, Throwable, Unit] =
    ZIO.effect(writeFile(file, text))
}
