/*
 * This file was generated by the Gradle "init" task.
 */

plugins {
    java
    `maven-publish`
}

repositories {
    mavenLocal()
    maven ("https://maven.scijava.org/content/groups/public")
    maven ("https://repo.maven.apache.org/maven2")
}

dependencies {
    implementation(project(":common"))
    implementation("net.imglib2:imglib2:5.6.3")
    implementation("org.scijava:scijava-common:2.77.0")
}

group = "net.imagej"
version = "0.3.2-SNAPSHOT"
description = "ImageJ UI: AWT"
//sourceCompatibility = "1.8"
//
//configurations.all {
//}
//
//java {
//    withSourcesJar()
//}
//
//publishing {
//    publications {
//        maven(MavenPublication) {
//            from(components.java)
//        }
//    }
//}
//
//tasks.withType(JavaCompile) {
//    options.encoding = "UTF-8"
//}
