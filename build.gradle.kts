group = "com.github.viimeinen1.amsg"
version = "1.0.1"
description = "small messaging library for plugins"

plugins {
    id("maven-publish")
    id("java-library")
    // id("java")
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
    withSourcesJar()
    withJavadocJar()
}