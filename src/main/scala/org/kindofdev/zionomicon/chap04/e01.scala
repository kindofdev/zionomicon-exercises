package org.kindofdev.zionomicon.chap04

import zio.ZIO

object e01 {
  def failWithMessage(string: String) = ZIO.succeed(
    throw new Error(string)
  )

  def notFailingWithDefects(string: String) =
    failWithMessage(string).catchAllDefect(_ => ZIO.succeed(()))

}
