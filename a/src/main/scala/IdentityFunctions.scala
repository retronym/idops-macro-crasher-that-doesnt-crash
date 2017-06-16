package scalaz
package data

import scalaz.meta.Ops
import scala.reflect.macros.whitebox.Context
import scala.language.experimental.macros

final class IdOps[A](self: A) extends Ops {
  type O = IdOpsImpls.type
  def squared: (A, A) = macro Ops.inline0
}

object IdOpsImpls {
  @inline final def squared[A](self: A): (A, A) =
    (self, self)
}