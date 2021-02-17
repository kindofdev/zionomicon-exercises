package org.kindofdev.zionomicon.chap02

import zio.ZIO

/**
 * Using ZIO.effectTotal, convert the following procedural function into a
 * ZIO function
 */
object e13 {
  def currentTime(): Long = System.currentTimeMillis()
  lazy val currentTimeZIO: ZIO[Any, Nothing, Long] = ZIO.effectTotal(currentTime())
}
