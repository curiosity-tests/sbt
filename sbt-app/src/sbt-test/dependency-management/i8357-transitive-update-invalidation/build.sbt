// Test for https://github.com/sbt/sbt/issues/8357
// Verifies that transitiveUpdate correctly invalidates across command invocations
// when a dependency's dependencies change.

ThisBuild / scalaVersion := "2.12.21"

// Use a setting to control library version - this can be changed via reload
lazy val catsVersion = settingKey[String]("Cats version")

lazy val a = project.in(file("a"))
  .settings(
    catsVersion := "2.8.0",
    libraryDependencies += "org.typelevel" %% "cats-core" % catsVersion.value,
  )

lazy val itTests = project.in(file("itTests"))
  .dependsOn(a % "test->test")
