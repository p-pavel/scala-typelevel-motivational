package com.perikov.typelevel.motivational

/** The problem with complement
  *
  * Scala's type system generally is based on
  *   - known types, including `Any`, `Nothing`, `AnyKind` (not considered here), `String` and
  *     literal types like `3`, `"myIdentifier"`, etc.
  *   - intersections and unions of types: `A & B`, `A | B`
  *   - language means for constructing traits, classes etc
  *   - variance annotations e.g. `type MyType[+A, -B]` that influence type checker behavior
  *     including treatment of intersections and unions
  *   - path-dependent types (what sets Scala aside, more on this in the section on proof objects)
  *   - compiler bugs
  *
  * @todo
  *   Elaborate
  */

object ComplementProblem
