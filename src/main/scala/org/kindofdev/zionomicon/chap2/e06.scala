package org.kindofdev.zionomicon.chap2

/**
 * Implement the zipWith function in terms of the toy model of a ZIO
effect. The function should return an effect that sequentially composes
the specified effects, merging their results with the specified user-defined
function.
 */
object e06 {
  final case class ToyZIO[-R, +E, +A](run: R => Either[E, A])

  def zipWith[R, E, A, B, C](
      self: ToyZIO[R, E, A],
      that: ToyZIO[R, E, B]
  )(f: (A, B) => C): ToyZIO[R, E, C] =
    ToyZIO { r =>
      for {
        a <- self.run(r)
        b <- that.run(r)
      } yield f(a, b)
    }
}
