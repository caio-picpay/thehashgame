plugins {
  id("org.jetbrains.kotlin.jvm").version("1.3.21")
  id("org.jetbrains.kotlin.plugin.spring").version("1.3.21")
  id("org.springframework.boot").version("2.6.6")
}

apply(plugin = "war")
apply(plugin = "io.spring.dependency-management")

repositories {
  mavenCentral()
  maven(url = "https://repo.spring.io/snapshot")
  maven(url = "https://repo.spring.io/milestone")
}

dependencies {
  implementation(project(":thehashgame"))
  implementation(project(":app"))

  compileOnly("org.projectlombok:lombok:1.18.22")
  annotationProcessor ("org.projectlombok:lombok:1.18.22")

  implementation("org.springframework.boot:spring-boot-starter-web")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}