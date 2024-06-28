package com.perikov.typelevel.motivational

/** here're some utility macros to simplify going through the code
  *
  * @note
  *   should be used outside this file
  *
  * @example
  *   {{{
  *   import macros.*
  *
  *   val a = typeReprStructureString["Asf" | "CE"].compileInfo
  *
  *   }}}
  */
object macros:

  /** @return
    *   string representation of the type structure. Please note that type is dealiased first
    */
  transparent inline def typeReprStructureString[T <: AnyKind]: String =
    ${ typeReprStructureStringImpl[T] }

  extension (s: String)
    /** Provides compile-time information.
      *
      * @note
      *   the string should be constant
      * @return
      *   the same string as passed
      */
    inline def compileInfo: s.type = ${ infoImpl[s.type]('s) }

    /** Provides compile-time warning.
      *
      * @note
      *   the string should be constant
      * @return
      *   the same string as passed
      */
    inline def compileWarn: s.type = ${ warnImpl[s.type]('s) }

  import scala.quoted.*

  private def typeReprStructureStringImpl[T <: AnyKind: Type](using Quotes): Expr[String] =
    import quotes.reflect.*
    val tpe = TypeRepr.of[T].dealias.simplified
    Expr(tpe.show(using Printer.TypeReprStructure))

  private def infoImpl[T <: String](s: Expr[T])(using Quotes): Expr[T] =
    import quotes.reflect.*
    report.info(s.valueOrAbort)
    s

  private def warnImpl[T <: String](s: Expr[T])(using Quotes): Expr[T] =
    import quotes.reflect.*
    report.warning(s.valueOrAbort)
    s

end macros
