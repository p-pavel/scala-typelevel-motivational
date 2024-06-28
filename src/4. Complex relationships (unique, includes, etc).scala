package com.perikov.typelevel.motivational

/** Now we do now what type bounds and proof objects can do for you.
  *
  * Lets's look at more complex relationships between types. What is the correct type for the CQL's
  * `Table`?
  *
  * {{{type Table(name: Identifier, columns: ColumnDefs, partitionKey: ???, clusteringKey: ???)}}}
  *
  * We know that:
  *   - `ColumnDefs` should not contain duplicate column names
  *   - `partitionKey` should be a subset of names `columns` and contains no duplicates
  *   - `clusteringKey` should be a subset of names in (`columns` \ `partitionKey`) and contain no
  *     duplicates
  *
  * What are our limits here? Can we go with type bounds or should we switch to proof objects?
  *
  * @todo
  *   Elaborate
  */
object ComplexRelationships
end ComplexRelationships
