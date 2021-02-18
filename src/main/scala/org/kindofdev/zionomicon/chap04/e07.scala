package org.kindofdev.zionomicon.chap04

import zio.ZIO

object e07 {
  def left[R, E, A, B](zio: ZIO[R, E, Either[A, B]]): ZIO[R, Either[E, B], A] =
    zio.foldM(
      e => ZIO.fail(Left(e)),
      {
        case Left(a) => ZIO.succeed(a)
        case Right(b) => ZIO.fail(Right(b))
      }
    )

  def unleft[R, E, A, B](zio: ZIO[R, Either[E, B], A]): ZIO[R, E, Either[A, B]] =
    zio.foldM({
      case Left(e) => ZIO.fail(e)
      case Right(b) => ZIO.right(b)
    }, a => ZIO.left(a))


}
