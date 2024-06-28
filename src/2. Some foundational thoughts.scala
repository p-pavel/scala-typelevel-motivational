package com.perikov.typelevel.motivational

/** ## Before diving into the problem of producing proper specifications in Scala let's discuss some
  * foundational ideas of typing.
  *
  * Why do we need strong (expressive) static typing and metaprogramming at all?
  *
  * I think we should reiterate the following points:
  *
  *   - documentation/specification: types deliver a formal mechanically checkable specification of
  *     the code
  *
  *   - runtime performance: good type systems allow us to produce optimal or near-optimal runtime
  *     data representation of the data structures without resorting to the variants of runtime type
  *     checks.
  *
  *   - separation of concerns: some data are not needed at runtime at all and can stay completely
  *     at type-checking phase.
  *
  *   - early error detection the earlier we detect the error the better. Detecting in runtime what
  *     could be detected at type checking phase is the worst case. It's often too late and too
  *     separated from code development (consider the ultimate case when there's no more source code
  *     nor developers at this point)
  *
  * We should also talk about to general approaches to what can be achieved with types and
  * metaprogramming:
  *
  *   - correct by construction
  *   - correct by verification at compile time
  *
  * In Scala we can put constraint on types using bounds only.
  *
  * Let's talk in more details about some of these topics in the following sections.
  */
object Foundations:
end Foundations
