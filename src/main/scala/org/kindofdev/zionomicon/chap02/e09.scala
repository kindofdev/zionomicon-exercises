package org.kindofdev.zionomicon.chap02

/**
 * Implement the orElse function in terms of the toy model of a ZIO effect.
The function should return an effect that tries the left hand side, but if
that effect fails, it will fallback to the effect on the right hand side.
 */
object e09 {
  final case class ToyZIO[-R, +E, +A](run: R => Either[E, A])

  def orElse[R, E1, E2, A](
      self: ToyZIO[R, E1, A],
      that: ToyZIO[R, E2, A]
  ): ToyZIO[R, E2, A] =
    ToyZIO { r =>
      self.run(r) match {
        case Left(_)  => that.run(r)
        case Right(a) => Right(a)
      }
    }

}
