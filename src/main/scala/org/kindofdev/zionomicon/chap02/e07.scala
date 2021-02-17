package org.kindofdev.zionomicon.chap02

import scala.annotation.tailrec

/**
 * Implement the collectAll function in terms of the toy model of a ZIO
 *effect. The function should return an effect that sequentially collects the
 *results of the specified collection of effects.
 */
object e07 {
  final case class ToyZIO[-R, +E, +A](run: R => Either[E, A])

  def collectAllR[R, E, A](
      in: Iterable[ToyZIO[R, E, A]]
  ): ToyZIO[R, E, List[A]] = {

    @tailrec
    def collect(in: Iterable[ToyZIO[R, E, A]], acc: Either[E, List[A]], r: R): Either[E, List[A]] =
      if (in.isEmpty)
        acc
      else
        in.head.run(r) match {
          case Left(e) => Left(e)
          case Right(a) =>
            acc match {
              case l @ Left(_) => l
              case Right(list) => collect(in.tail, Right(list :+ a), r)
            }
        }

    ToyZIO { r =>
      collect(in, Right(List.empty[A]), r)
    }

  }

  def collectAll[R, E, A](
      in: Iterable[ToyZIO[R, E, A]]
  ): ToyZIO[R, E, List[A]] =
    ToyZIO { r =>
      in.foldLeft(Right(List.empty[A]).withLeft[E]) { (acc, zio) =>
        acc match {
          case l @ Left(_) => l
          case Right(list) =>
            zio.run(r) match {
              case Left(e)  => Left(e).withRight[List[A]]
              case Right(a) => Right(list :+ a).withLeft[E]
            }
        }
      }
    }

}
