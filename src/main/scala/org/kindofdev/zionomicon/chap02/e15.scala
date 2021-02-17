package org.kindofdev.zionomicon.chap02

import zio.ZIO

/**
 * Using ZIO.effectAsync, convert the following asynchronous, callback-based function into a ZIO function
 */
object e15 {
  trait User

  def saveUserRecord(
      user: User,
      onSuccess: () => Unit,
      onFailure: Throwable => Unit
  ): Unit =
    ???

  def saveUserRecordZio(user: User): ZIO[Any, Throwable, Unit] =
    ZIO.effectAsync { register =>
      saveUserRecord(
        user,
        () => register(ZIO.succeed(())),
        throwable => register(ZIO.fail(throwable))
      )
    }
}
