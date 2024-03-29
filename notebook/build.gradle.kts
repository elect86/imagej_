/*
 * This file was generated by the Gradle "init" task.
 */

plugins {
    java
    `maven-publish`
}

dependencies {
    implementation(project(":common"))
    implementation(project(":ops"))
    implementation("net.imglib2:imglib2:5.6.3")
    implementation("org.scijava:scijava-common:2.77.0")
    implementation("org.scijava:scijava-table:0.4.0")
    implementation("org.apache.commons:commons-text:1.6")
    implementation("org.knowm.xchart:xchart:3.5.4")
    testImplementation("junit:junit:4.12")
    testImplementation("io.scif:scifio:0.37.3")
    testImplementation(project(":ui-swing"))
    compileOnly("com.github.jupyter:jvm-repr:0.2.1")
    compileOnly("com.github.twosigma.beakerx:beaker-kernel-base:1.0.0")

    // [Gradle]
    implementation("net.imglib2:imglib2-algorithm:0.11.2")
}

version = "0.7.2-SNAPSHOT"
description = "ImageJ Notebook"