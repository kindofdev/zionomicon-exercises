package org.kindofdev.zionomicon.chap04

import zio.{Cause, ZIO}

object e09 {
  def catchAllCause[R, E1, E2, A](zio: ZIO[R, E1, A], handler: Cause[E1] => ZIO[R, E2, A]): ZIO[R, E2, A] =
    zio.sandbox.foldM(handler, a => ZIO.succeed(a))
}
