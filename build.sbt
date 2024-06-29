Global / onChangedBuildSource := ReloadOnSourceChanges
lazy val motivate = project
  .in(file("."))
  .settings(
    scalaVersion          := "3.4.2",
    organization          := "com.perikov",
    name                  := "typelevel-motivational",
    version               := "1.0.0-SNAPSHOT",
    libraryDependencies   += "com.perikov" %% "typelevel" % "1.0.0",
    Compile / scalaSource := baseDirectory.value / "src",
    Compile / doc / scalacOptions ++=
      Seq(
        "-sourcepath",
        "docs",
        "-doc-title",
        "Typelevel Motivational",
        "-d",
        "minisite",
        "-snippet-compiler:compile"
      )
  )
