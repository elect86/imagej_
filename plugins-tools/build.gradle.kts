/*
 * This file was generated by the Gradle "init" task.
 */

plugins {
    java
    `maven-publish`
}

dependencies {
    implementation(project(":common"))
    implementation("net.imglib2:imglib2:5.6.3")
    implementation("org.scijava:scijava-common:2.77.0")
}

version = "0.3.2-SNAPSHOT"
description = "ImageJ Plugins: Tools"