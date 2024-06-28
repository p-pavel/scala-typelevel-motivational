# (Hopefully) motivational talk on using Scala as specification language

The code is in [src](https://github.com/p-pavel/scala-typelevel-motivational/tree/main/src) folder,
I will collect it hear as text. PLEASE take a look inside the `src`, the code IS mostly
text and organised as a book:

![src](assets/src.png)

This is work in progress intended to be finished today, 2024-06-28,
so if you are interested, check the page periodically.

I started my journey with softare engineering ~30 years ago,
professionally worked with C, C++, Java, Smalltalk, C#, Python, Haskell, Agda, Scala
and more.

I currently see the microservice catastrophe marching and the rise of ancient evil like Go.

My interests include:

- Scala as an industrial grade specification language
  - type level and macro programming utilities
  - development of [tagless final ideas](https://duckduckgo.com/?q=tagless+final+interpreters&t=osx&ia=web) for
    Scala and its capabilities (see [this](https://github.com/p-pavel/osgi-scala-maven/tree/main/modelling) to get a high level picture)
  - development of [parametric parametricity](https://www2.cs.sfu.ca/CourseCentral/831/burton/Notes/July14/free.pdf)
    ideas for Scala
  - development of techniques and tools to push Scala into proof assistant category
    similar to Agda (ability to discuss the topic with the type checker)
  - express industrial knowledge as Scala specs and develop the libraries from this
    (consider industrial patterns like "event sourcing", or "CQRS" expressed not as
    pity words but as formal executable spec)
  - develop the techniques for API design and evolution connected to the types in Scala
    - Can I pass the immutable source files to the developers and if they come with
      something that will make this code compile I can be pretty sure they
      implemented the spec? (yes, we can run scalacheck and munit in compile time)
    - Can API evolution be connected to subtyping?
    - - Can the structure of our specs reflect the stages of the design, including
        elaboration and refinement leading to more and precise types?
- software engineering with Scala on JVM using OSGi and general capability/requirement model and packages
  in JVM sense
  - a tool to automatically generate OSGi bundles and Karaf feature repositories
    from Scala libraries (the development of [this theme](https://github.com/p-pavel/osgi-scala))
- IDE to support proper Scala development wich isolates the developer from dealing with project and
  dependencies focusing on automaticall finding the dependencies from maven. Tightly integrated with
  OSGi container to get the illusion of live code development and automating proper OSGi bundle creation

Unfortunately, there're little chances to continue this work due to time limitations (limiting factor beeing the cigarretes and food supple and also accomodation) and the
lack of general interest in the topic.

But if you are interested, please consider [sponsorship](https://github.com/sponsors/p-pavel) and participating
in the [discussions](https://github.com/p-pavel/scala-typelevel-motivational/discussions)