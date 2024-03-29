/*
 * This file was generated by the Gradle "init" task.
 */

plugins {
    java
    `maven-publish`
}

dependencies {
    implementation("org.scijava:scijava-common:2.83.3")
    implementation("net.imglib2:imglib2:5.10.0")
    implementation("org.apache.commons:commons-math3:3.6.1")
    testImplementation("junit:junit:4.13")
    testImplementation("net.imglib2:imglib2-roi:0.10.3")
    testImplementation("io.scif:scifio:0.41.0")
}

version = "0.8.2-SNAPSHOT"
description = "ImageJ Mesh"