package com.perikov.typelevel.motivational

/** To this points we talked on putting constraints on types, specifying the requirements for the
  * types themselves. we just touched the surface of the topic of what terms are valid for the types
  * in question.
  *
  * There're some considerations to be made:
  *   - terms (values) is what actuall "happens" in runtime, "does the real work"
  *   - Scala's meta-programming facilities work completely on term levels, you can't generate type
  *     definitions in compile time (at least in Scala 3). You can do some definition checking and
  *     provide not-visible-to-the-user new definitions with experimental `macroannotations` but
  *     that's it.
  *   - remember Curry-Howard isomorphism: types are propositions, terms are proofs. So, if we need
  *     to prove something we usually have to proof the inhabitance of some type (our ability to
  *     produce values of this type)
  *
  * The latter has deep correspondence with term derifing facilities in Scala. `Given` (pun
  * intended) a "proof theory" the compiler can derive the term (our proof) in many cases.
  */
object ProofObjects:
end ProofObjects
