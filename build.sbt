val a = project settings(libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value)
val b = project dependsOn a

scalaVersion in ThisBuild := (crossScalaVersions in ThisBuild).value.head

crossScalaVersions in ThisBuild := List("2.12.2", "2.11.11")