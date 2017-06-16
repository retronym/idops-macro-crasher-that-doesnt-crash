package scalaz
package meta

import scala.reflect.macros.whitebox.Context
import scala.language.experimental.macros
import scala.reflect.macros.whitebox

// Originally inspired by http://typelevel.org/blog/2013/10/13/spires-ops-macros.html

trait Ops {
  type O
}

object Ops {

  def inline0(c: Context): c.Tree = {
    import c.universe._
    val q"new ${cl: TypeTree}($p)" = c.prefix.tree
    val moduleTySym = cl.tpe.member(TypeName("O")).typeSignature
    val module = Ident(moduleTySym.termSymbol)
    val pre = c.prefix
    val appName = c.macroApplication.symbol.name.toString
    println(module)
    q"$module.${TermName(appName)}($p)"
  }

}