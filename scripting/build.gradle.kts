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
    implementation("org.scijava:scripting-beanshell:0.3.3")
    implementation("org.scijava:scripting-clojure:0.1.6")
    implementation("org.scijava:scripting-groovy:0.2.7")
    implementation("org.scijava:scripting-java:0.4.1")
    implementation("org.scijava:scripting-javascript:0.4.4")
    implementation("org.scijava:scripting-jruby:0.3.0")
    implementation("org.scijava:scripting-jython:0.4.2")
    implementation("org.scijava:scripting-renjin:0.2.2")
    implementation("org.scijava:scripting-scala:0.2.1")
    testImplementation("junit:junit:4.12")
    testImplementation("org.scijava:junit-benchmarks:0.7.4-scijava")
    testImplementation("io.scif:scifio:0.37.3")
    testImplementation(project(":ops"))
}

group = "net.imagej"
version = "0.8.3-SNAPSHOT"
description = "ImageJ Scripting"
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
