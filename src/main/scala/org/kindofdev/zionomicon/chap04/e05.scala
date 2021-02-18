package org.kindofdev.zionomicon.chap04

import zio.ZIO

import java.io.IOException

object e05 {
  def ioException[R, A](zio: ZIO[R, Throwable, A]): ZIO[R, java.io.IOException, A] =
    zio.refineOrDie {
      case ex: IOException => ex
    }
}
