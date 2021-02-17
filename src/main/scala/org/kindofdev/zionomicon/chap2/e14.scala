package org.kindofdev.zionomicon.chap2

import zio.ZIO

/**
 * Using ZIO.effectAsync, convert the following asynchronous, callback-based function into a ZIO function
 */
object e14 {

  def getCacheValue(
      key: String,
      onSuccess: String => Unit,
      onFailure: Throwable => Unit
  ): Unit =
    ???

  def getCacheValueZio(key: String): ZIO[Any, Throwable, String] =
    ZIO.effectAsync { register =>
      getCacheValue(
        key,
        value => register(ZIO.succeed(value)),
        throwable => register(ZIO.fail(throwable))
      )
    }
}
