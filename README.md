docker-scala-protoc

scalapb compiler

```
docker run -v `pwd`:/def scalapb sbt compile
```

```
docker run -e OUT=gen-scala -v `pwd`:/def scalapb sbt compile
```
