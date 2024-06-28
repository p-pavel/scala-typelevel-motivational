package com.perikov.typelevel.motivational

/** This is a long section devised to demonstrate the insane capabilities of Scala's type system.
  *
  * It can be skimmed through if you think that such amount of details is not needed.
  *
  * Let's look at the simplest thing from the initial example (the [[Identifier]] type).
  * {{{
  * type Identifier <: String
  * }}}
  */
trait PlayingWithIdentifier:

  /** Looking at the
    * [docs](https://cassandra.apache.org/doc/latest/cassandra/developing/cql/definitions.html#identifiers)
    * we know that:
    *   - identifiers are strings
    *   - there're two kind of strings eligible to being identifiers: quoted and unquoted
    *   - \- unquoted identifiers are case-insensitive
    *   - \- - we have simple regular expressions for them
    *   - \- some of them are reserved keywords
    *   - \- quoted identifiers are case-sensitive
    *
    * Let's discuss what of this can be put into the spec considering the following axes:
    *   - correctness by construction vs correctness by verification
    *   - runtime representation
    *
    * Let specify what we've learned from the docs to this point. This part is here to to show how
    * we can use the type system to research the problem at hand with the assistance of the type
    * checker.
    */
  type QuotedIdentifier <: String
  type UnqotedIdentifierLike <: String
  type Keyword <: UnqotedIdentifierLike
  type UnqotedIdentifier <: UnqotedIdentifierLike
  type Identifier = QuotedIdentifier | UnqotedIdentifier

  /** This gives us a row idea of sub-types/sub-sets representation of the problem domain.
    *
    * Can we do any better? What knowledge we got from docs and didn't put here?
    *
    * Well, much actually.
    *
    *   - we probably know the exact list of reserved keywords
    *   - we know the exact regular expression for unquoted and quoted identifier-like strings
    *
    * We will talk about keywords in the corresponding subsection
    */
  object p1

end PlayingWithIdentifier
