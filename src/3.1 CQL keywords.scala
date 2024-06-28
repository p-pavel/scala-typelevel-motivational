package com.perikov.typelevel.motivational


/** let's update our knowledge on keywords *
  *
  * @see
  *   https://cassandra.apache.org/doc/latest/cassandra/developing/cql/appendices.html#appendix-A
  *
  * We are currently working with [[Identifier]] idea so we're most interested about `reserved`
  * keywords, that look like identifiers but can't be used as such.
  */
trait Keywords:

  /** We put them into (type-level) tuple and not use union type for the reasons that will be clear
    * later.
    */
  type ExampleKeywords = ("ADD", "ALLOW", "ALTER", "AND", "APPLY" /*, ..*/ )

  import scala.compiletime
  import compiletime.{constValue, ops}
  import ops.string.*
  import ops.boolean.*
  import ops.any.*

  /** What we actually need is "type level function" (not just predicate), a decision procedure that
    * can distinguish strings that are reserved keywords from those that are not.
    *
    * {{ type IsReservedKeyword[K <: String] <: Boolean }}
    *
    * How can we approach this? Well, let's go for `scala.compiletime.ops.string` and see what is
    * achievable.
    *
    * Let's start with constructing regular expression for unqoted identifiers.
    */
  type UnqoutedIdentifierRegex          = "[a-zA-Z_][a-zA-Z0-9_]*"
  type UppercaseUnqoutedIdentifierRegex = "[A-Z_][A-Z0-9_]*"

  /** Let's form the type that is regex for reserved keywords */
  type ReservedKeywordRegex =
    Tuple.Fold[
      ExampleKeywords,
      "",
      [X, Y] =>> ToString[X] + "|" + ToString[Y]
    ]


  /**
    * @todo tell the story of reserved keywords 
    * leading to the trait that can be passed to other for refinement (collecting all keywords)
    */
  object TheStoryOfReservedKeywords
     

  //TODO: Tell the story of putting proof obligations here and using the macro 
  // utilities to look at types 
  import macros.*
  typeReprStructureString[ReservedKeywordRegex].compileInfo

  inline def andIsKeyword: true =
    inline if constValue[Matches["AND", ReservedKeywordRegex]] == true
    then true
    else compiletime.error("AND is not recognized as a keyword")

  andIsKeyword
end Keywords
