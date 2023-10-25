buildscript {
//    ext.kotlin_version = '1.6.21'

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.google.gms:google-services:4.3.14")
        classpath ("com.android.tools.build:gradle:8.1.1")
//        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}
//task clean(type: Delete) {
//    delete rootProject.buildDir
//}