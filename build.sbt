import scalapb.compiler.Version.{grpcJavaVersion, scalapbVersion, protobufVersion}

scalaVersion := "2.12.6"

// compiles protobuf definitions into scala code
val protoDirectory = "../def"


PB.protoSources in Compile := Seq(file(protoDirectory))

val output : String = s"$protoDirectory/${sys.env.getOrElse("OUT", "scala")}"

PB.targets in Compile := Seq(
  scalapb.gen() -> (baseDirectory.value / output)
)

libraryDependencies ++= Seq(
  "com.thesamet.scalapb" %% "scalapb-runtime" % scalapbVersion % "protobuf",
  "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapbVersion,
)
