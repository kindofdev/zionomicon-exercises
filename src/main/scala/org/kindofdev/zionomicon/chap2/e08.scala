package org.kindofdev.zionomicon.chap2

import scala.annotation.tailrec

/**
 * Implement the foreach function in terms of the toy model of a ZIO effect.
 *The function should return an effect that sequentially runs the specified
 *function on every element of the
 */
object e08 {
  final case class ToyZIO[-R, +E, +A](run: R => Either[E, A])

  def foreach[R, E, A, B](
      in: Iterable[A]
  )(f: A => ToyZIO[R, E, B]): ToyZIO[R, E, List[B]] = {

    @tailrec
    def forEachR(in: Iterable[A], acc: Either[E, List[B]], r: R): Either[E, List[B]] =
      if (in.isEmpty)
        acc
      else
        f(in.head).run(r) match {
          case Left(e) => Left(e)
          case Right(b) =>
            acc match {
              case l @ Left(_) => l
              case Right(list) => forEachR(in.tail, Right(list :+ b), r)
            }
        }

    ToyZIO { r =>
      forEachR(in, Right(List.empty[B]), r)
    }

  }

}
