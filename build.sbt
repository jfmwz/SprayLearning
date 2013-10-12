import AssemblyKeys._

assemblySettings

name :="forest"

organization  := "com.example"

version := "0.2"

scalaVersion  := "2.10.2"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/",
  "night" at "http://nightlies.spray.io/",
  "kafka" at "https://repository.apache.org/content/repositories/releases",
  "sona" at "https://oss.sonatype.org/content/repositories/releases/"
)

libraryDependencies ++= Seq(
  "io.spray"            %   "spray-can"     	% "1.2-20131004",
  "io.spray"            %   "spray-routing" 	% "1.2-20131004",
  "io.spray"            %   "spray-testkit" 	% "1.2-20131004" % "test",
  "com.typesafe.akka"   %%  "akka-actor"    	% "2.2.1",
  "com.typesafe.akka"   %%  "akka-testkit"  	% "2.2.1" % "test",
  "org.specs2"          %%  "specs2"        	% "1.14" % "test",
  "org.json4s" 			%% 	"json4s-native" 	% "3.2.4",
  "org.mongodb" 		%% "casbah" 			% "2.6.2",
  "com.typesafe" 		%% "scalalogging-slf4j" % "1.0.1",
  "org.slf4j" 			% "slf4j-api" 			% "1.7.1",
  "org.slf4j" 			% "log4j-over-slf4j" 	% "1.7.1",
  "ch.qos.logback" 		% "logback-classic" 	% "1.0.3",
  "com.novus" %% "salat" % "1.9.3",
  "org.specs2" %% "specs2" % "2.2.1" % "test",
  "org.apache" % "kafka_2.10" % "0.8-SNAPSHOT" intransitive(),
  "com.yammer.metrics" % "metrics-core" % "2.2.0",
  "com.yammer.metrics" % "metrics-annotation" % "2.2.0",
  "com.github.velvia" %% "scala-storm" % "0.2.3-SNAPSHOT",
  "storm" % "storm" % "0.8.1"  exclude("junit", "junit")
)

//"storm" % "storm" % "0.8.1" % "provided" exclude("junit", "junit")
seq(Revolver.settings: _*)

mainClass in assembly := Some("com.example.Boot")
