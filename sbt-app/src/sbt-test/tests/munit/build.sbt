val munit = "org.scalameta" %% "munit" % "1.0.4"
scalaVersion := "3.8.3"

lazy val root = rootProject
  .settings(
    libraryDependencies += munit % Test
  )
