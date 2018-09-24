name := "geometry_draw"

version := "0.1"

scalaVersion := "2.12.6"

// parser-combinator library
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.1"

// read-eval-print loop library
libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value

// testing libraries
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.0" % "test"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"