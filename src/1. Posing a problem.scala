package com.perikov.typelevel.motivational

/** We start by posing a problem that we will solve in the following sections.
  *
  * Let's say we need to design CQL table definition (simplified for the sake of the example) Let
  * first approach the problem as most of us being taught
  * @see
  *   https://cassandra.apache.org/doc/latest/cassandra/developing/cql/ddl.html#create-table-statement
  */
trait TranditionalDesign:

  case class ColumnDef(name: String, dataType: String)
  case class Table(
      name: String,
      columns: Seq[ColumnDef],
      partitionKeys: Seq[String],
      clusteringKeys: Seq[String]
  )

  /** This is a valid definition of term of type [[Table]], that is completely invalid CQL table
    */
  val myTable = Table(
    "my table",
    Seq(
      ColumnDef("", "int"),
      ColumnDef("name", "text"),
      ColumnDef("name", "jubberwokey")
    ),
    partitionKeys = Seq("id"),
    clusteringKeys = Seq("id")
  )

end TranditionalDesign

/** What problems do we see?
  *
  *   - our types a completely composed from unions,products and [[String]]s, [[Seq]] being an
  *     opaque abstraction. from all [[Table]]s and [[ColumnDef]] most are not VALID CQL tables and
  *     we no this from the beginning
  *   - the code tell us nothing about what [[Table]] values are indeed valid
  *   - nor compiler nor constructors for the types in question do not check for validity
  *
  * So the code above is bad as the specification and is extemely bad in terms of "Fail early"
  * principle.
  *
  * Fail early principle states that the errors should be diagnosed as early as possible.
  * Traditionally this would mean doing some checks at runtime and throwing exceptions, or other
  * ways to signal the error.
  *
  * This would mean that moment is completely disconnected from the moment the code.
  *
  * Putting comments into the code will not help much, as the comments are not checked by the
  * compiler and quickly become outdated and are rarely read by the developers.
  *
  * Let's start approaching the problem with at least abstracting some types.
  *
  * Please note, that we DON'T need all this to have a working program, so 90% of so called
  * "software engineers" will tell you this is not needed and "too complex". Complexity often is a
  * synonym for "I'm not aware of this" even if "this" are things like set intersection/unions, etc.
  *
  * Nevertheless, we will proceed with the following design assuming that we can approach the state
  * where code is the complete specification of the problem domain, much better then textual
  * documentation for the following reason: it can be mechanically checked by the compiler. "The
  * code does not lie" and is very good for reuse, because type checker's work costs nothing
  * compared to human work.
  *
  * Compared to AI type checker is based on the formal system too, that was checked by somebody for
  * soundness, at least in theory.
  */
trait AlmostTraditionalDesign:

  /** We're already using advanced Scala feautre: abstract types not available in majority of the
    * languages that opens the possibility to reason about parametric parametricity.
    *
    * Another advanced feature here is type bounds. We can instantly see that not all strings are valid
    * [[Identifier]]s, but all [[Identifier]]s are strings.
    */
  type Identifier <: String

  /** Datatype is purely abstract for now */
  type Datatype

  case class ColumnDef(Identifier: String, dataType: Datatype)

  case class Table(
      name: Identifier,
      columns: Seq[ColumnDef],
      partitionKeys: Seq[Identifier],
      clusteringKeys: Seq[Identifier]
  )
end AlmostTraditionalDesign
