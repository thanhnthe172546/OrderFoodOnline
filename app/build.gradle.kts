plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services) // Corrected plugin alias syntax
}

android {
    namespace = "com.example.projectbl5"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.projectbl5"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Firebase dependencies with BoM (Bill of Materials)
    implementation(platform("com.google.firebase:firebase-bom:33.0.0")) // Use platform() for BoM
    implementation("com.google.firebase:firebase-analytics") // No version needed with BoM
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-firestore")

    // Other dependencies
    implementation("com.google.code.gson:gson:2.10.1") // Updated to a newer version
    implementation("androidx.appcompat:appcompat:1.6.1") // Explicit version
    implementation("com.google.android.material:material:1.12.0") // Updated material, corrected group
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.credentials) // Assuming these are defined in version catalog
    implementation(libs.credentials.play.services.auth)
    implementation(libs.googleid)
    implementation(libs.firebase.database)

    // Test dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}