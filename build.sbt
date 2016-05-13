lazy val sparkVersion = "1.6.1"

lazy val buildSettings = Seq(
  organization := "io.github.benfradet",
  version := "1.0",
  scalaVersion := "2.11.8",
  libraryDependencies ++= Seq(
    "org.apache.spark" %% "spark-core",
    "org.apache.spark" %% "spark-mllib",
    "org.apache.spark" %% "spark-sql"
  ).map(_ % sparkVersion % "provided") :+
    "com.databricks" %% "spark-csv" % "1.4.0"
)

lazy val compilerOptions = Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Xfuture",
  "-Xlint"
)

lazy val kaggle = project.in(file("."))
  .settings(moduleName := "spark-kaggle")
  .settings(buildSettings)
  .aggregate(titanic, sfCrime)

lazy val titanic = project
  .settings(moduleName := "titanic")
  .settings(buildSettings)

lazy val sfCrime = project
  .settings(moduleName := "sfCrime")
  .settings(buildSettings)