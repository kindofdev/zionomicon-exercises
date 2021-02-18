package org.kindofdev.zionomicon.chap04

import zio.ZIO

object e08 {
  def right[R, E, A, B](zio: ZIO[R, E, Either[A, B]]): ZIO[R, Either[E, A], B] =
    zio.foldM(
      e => ZIO.fail(Left(e)),
      {
        case Left(a) => ZIO.fail(Right(a))
        case Right(b) => ZIO.succeed(b)
      }
    )

  def unright[R, E, A, B](zio: ZIO[R, Either[E, A], B]): ZIO[R, E, Either[A, B]] =
    zio.foldM(
      {
        case Left(e) => ZIO.fail(e)
        case Right(a) => ZIO.left(a)
      }, b => ZIO.right(b)
    )
}
