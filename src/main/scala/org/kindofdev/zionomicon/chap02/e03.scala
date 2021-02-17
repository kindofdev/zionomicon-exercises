package org.kindofdev.zionomicon.chap02

import zio.ZIO

/**
 * Using the flatMap method of ZIO effects, together with the readFileZio
and writeFileZio functions that you wrote, implement a ZIO version of
the function copyFile.
 */
object e03 {
  import e01._
  import e02._

  def copyFile(source: String, dest: String): Unit = {
    val contents = readFile(source)
    writeFile(dest, contents)
  }

  def copyFileZio(source: String, dest: String): ZIO[Any, Throwable, Unit] =
    readFileZio(source).flatMap(text => writeFileZio(dest, text))
}
