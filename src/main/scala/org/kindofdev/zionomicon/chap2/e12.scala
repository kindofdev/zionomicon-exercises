package org.kindofdev.zionomicon.chap2

import zio.ZIO

/**
 * Using ZIO.fail and ZIO.succeed, implement the following function,
 *which converts a List into a ZIO effect, by looking at the head element in
 *the list and ignoring the rest of the elements.
 */
object e12 {

  def listToZIO[A](list: List[A]): ZIO[Any, None.type, A] =
    list.headOption match {
      case Some(a) => ZIO.succeed(a)
      case None    => ZIO.fail(None)
    }

}
