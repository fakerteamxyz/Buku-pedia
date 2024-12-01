// File build.gradle.kts di tingkat atas (Top-level build file)
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("org.jetbrains.kotlin.kapt") version "1.8.0" apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
}
