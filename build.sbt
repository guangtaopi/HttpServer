name := "y"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "org.springframework" % "spring-expression" % "3.2.3.RELEASE",
  "org.springframework" % "spring-jdbc" % "3.2.3.RELEASE",
  "org.springframework" % "spring-aop" % "3.2.3.RELEASE",
  "org.mybatis" % "mybatis-spring" % "1.2.2",
  "org.mybatis" % "mybatis" % "3.2.4",
   "com.jolbox" % "bonecp" % "v0.8.0.RELEASE",
   "mysql" % "mysql-connector-java" % "5.1.28"
)

play.Project.playJavaSettings
