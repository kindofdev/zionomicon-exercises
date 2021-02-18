package org.kindofdev.zionomicon.chap04

import zio.ZIO

object e02 {
  // TODO -  ZIO[R, E, A] as output type ? errata?
  def recoverFromSomeDefects[R, E, A](zio: ZIO[R, E, A])(f: Throwable => Option[A]): ZIO[R, E, A] = ???

}
