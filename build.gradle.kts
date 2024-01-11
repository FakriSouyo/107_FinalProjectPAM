// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra.apply {
        set("nav_version", "2.6.0")
        set("hilt_version", "2.46.1")
        set("room_version", "2.5.2")
    }
}


plugins {
    id ("com.android.library") version "8.0.0" apply false
    id("com.android.application") version "8.0.0" apply false
    id("org.jetbrains.kotlin.android") version "1.7.20" apply false
    id ("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1" apply false
    id ("com.google.dagger.hilt.android") version "2.46.1" apply false
}