package org.kindofdev.zionomicon.chap04

import zio.ZIO

object e04 {
  // TODO - possible errata  handler: ZIO[R, E, Any]
  //  def onAnyFailure[R, E, A](zio: ZIO[R, E, A], handler: ZIO[R, E, Any]): ZIO[R, E, A] =

  def onAnyFailure[R, E, A](zio: ZIO[R, E, A], handler: ZIO[R, E, A]): ZIO[R, E, A] =
    zio.foldCauseM(
      _ => handler,
      _ => zio
    )

  //    zio.orElse(handler)

}
