resolvers += {
  val typesafeRepoUrl = new java.net.URL("http://repo.typesafe.com/typesafe/releases")
  val pattern = Patterns(false, "[organisation]/[module]/[sbtversion]/[revision]/[type]s/[module](-[classifier])-[revision].[ext]")
  Resolver.url("Typesafe Repository", typesafeRepoUrl)(pattern)
  Resolver.url("artifactory", url("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)
}

libraryDependencies += "commons-httpclient" % "commons-httpclient" % "3.1"

libraryDependencies += "commons-io" % "commons-io" % "2.4"

libraryDependencies += "org.clapper" % "scalasti_2.9.1" % "0.5.8"

libraryDependencies += "jline" % "jline" % "1.0"


addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.1.2")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.8.4")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")