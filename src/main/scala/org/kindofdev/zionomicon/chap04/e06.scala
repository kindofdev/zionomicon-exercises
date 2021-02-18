package org.kindofdev.zionomicon.chap04

import zio.ZIO

object e06 {
  val parseNumber: ZIO[Any, Throwable, Int] = ZIO.effect("foo".toInt)
  lazy val refinedParseNumber = parseNumber.refineToOrDie[NumberFormatException]
}
