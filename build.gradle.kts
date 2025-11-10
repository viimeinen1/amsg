import com.vanniktech.maven.publish.SonatypeHost

group = "io.github.viimeinen1.amsg"
version = "1.0.1"
description = "small messaging library for plugins"

plugins {
    id("java-library")
    id("com.vanniktech.maven.publish") version "0.34.0"
}

repositories {
    mavenLocal()
    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/") 
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.10-R0.1-SNAPSHOT")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

mavenPublishing {
  publishToMavenCentral()

  signAllPublications()
}

mavenPublishing {
  coordinates("com.github.viimeinen1.amsg", "amsg", "1.0.1")

  pom {
    name.set("aMsg")
    description.set("Small messaging library")
    inceptionYear.set("2025")
    url.set("https://github.com/username/mylibrary/")
    licenses {
      license {
        name.set("The Apache License, Version 2.0")
        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
        distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
      }
    }
    developers {
      developer {
        id.set("username")
        name.set("User Name")
        url.set("https://github.com/username/")
      }
    }
    scm {
      url.set("https://github.com/username/mylibrary/")
      connection.set("scm:git:git://github.com/username/mylibrary.git")
      developerConnection.set("scm:git:ssh://git@github.com/username/mylibrary.git")
    }
  }
}