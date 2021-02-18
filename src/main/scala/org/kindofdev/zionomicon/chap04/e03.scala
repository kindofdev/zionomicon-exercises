package org.kindofdev.zionomicon.chap04

import zio.ZIO

object e03 {
  def logFailures[R, E, A](zio: ZIO[R, E, A]): ZIO[R, E, A] =
    zio.foldCauseM(
      cause => {
        cause.prettyPrint
        zio
      },
      _ => zio
    )
}
