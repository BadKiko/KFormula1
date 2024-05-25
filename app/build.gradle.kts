plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    kotlin("kapt")
    kotlin("plugin.serialization") version "2.0.0"
    id("com.google.dagger.hilt.android") version "2.46" apply true
}

android {
    namespace = "com.kiril.raceapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.kiril.raceapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        buildConfig = true
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        all {
            buildConfigField(
                "String",
                "SUPABASE_URL",
                "\"https://jynfyinzgmldtbfvnyyp.supabase.co\""
            )
            buildConfigField(
                "String",
                "SUPABASE_KEY",
                "\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imp5bmZ5aW56Z21sZHRiZnZueXlwIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTU2NTYzOTcsImV4cCI6MjAzMTIzMjM5N30._cFBoVlPgA6GH5e8b70Qwu7xeHnLscwE-UuUUgFfb3E\""
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"

    }
}

dependencies {
    implementation("com.squareup.moshi:moshi:1.15.0")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.15.0")

    implementation(libs.sandwich)
    implementation(libs.sandwich.retrofit)

    // Retrofit for API calls
    implementation(libs.retrofit)
    implementation(libs.converter.moshi)

    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.46")
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    kapt("com.google.dagger:hilt-android-compiler:2.46")

    implementation(platform("io.github.jan-tennert.supabase:bom:2.4.1"))
    implementation("io.github.jan-tennert.supabase:postgrest-kt:2.4.1")
    implementation("io.github.jan-tennert.supabase:storage-kt")
    implementation(libs.ktor.client.android)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}