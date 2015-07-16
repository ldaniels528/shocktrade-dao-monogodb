import sbt._
import Keys._

name := "shocktrade-dao-mongodb"

organization := "com.ldaniels528"

version := "0.1.1"

scalaVersion := "2.11.6"

scalacOptions ++= Seq("-deprecation", "-encoding", "UTF-8", "-feature", "-target:jvm-1.7", "-unchecked",
    "-Ywarn-adapted-args", "-Ywarn-value-discard", "-Xlint")

javacOptions ++= Seq("-Xlint:deprecation", "-Xlint:unchecked", "-source", "1.7", "-target", "1.7", "-g:vars")

// General Dependencies
libraryDependencies ++= Seq(
	"joda-time" % "joda-time" % "2.7",
	"org.joda" % "joda-convert" % "1.7",
	"org.mongodb" %% "casbah-commons" % "2.8.0",
	"org.mongodb" %% "casbah-core" % "2.8.0",
	"org.slf4j" % "slf4j-api" % "1.7.10"
)            
            
// Shocktrade Dependencies
libraryDependencies ++= Seq(
	"com.ldaniels528" %% "shocktrade-util" % "0.1.1"
)
	
// Testing Dependencies
libraryDependencies ++= Seq(
	"junit" % "junit" % "4.11" % "test"
)