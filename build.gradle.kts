plugins {
    id("com.android.application") version "9.5.1"
    id("org.jetbrains.kotlin.plugin.compose") version "2.4.21"
}
android {
    namespace = "sample.compose"
    compileSdk = 37
    defaultConfig {
        applicationId = "sample.compose"
        minSdk = 23
        targetSdk = 37
    }
    buildFeatures {
        compose = true
    }
}
dependencies {
    implementation("androidx.compose.material:material:1.12.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.12.1")
    debugImplementation("androidx.compose.ui:ui-tooling:1.12.1")
    implementation("io.coil-kt.coil3:coil-compose:3.6.3")
    implementation("io.coil-kt.coil3:coil-network-okhttp:3.6.3")
    implementation("io.coil-kt.coil3:coil-svg:3.6.3")
}
