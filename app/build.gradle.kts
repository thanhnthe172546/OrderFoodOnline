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
    // Firebase dependencies with BoM
    implementation (platform("com.google.firebase:firebase-bom:33.4.0"))
    implementation ("com.google.firebase:firebase-analytics")
    implementation ("com.google.firebase:firebase-auth")
    implementation ("com.google.firebase:firebase-firestore")
    implementation ("com.google.firebase:firebase-storage")
    implementation ("com.google.firebase:firebase-database")

    // Firebase UI for Authentication
    implementation ("com.firebaseui:firebase-ui-auth:7.2.0")

    // Glide
    implementation ("com.github.bumptech.glide:glide:4.11.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.11.0")

    // Lombok
    compileOnly ("org.projectlombok:lombok:1.18.34")
    annotationProcessor ("org.projectlombok:lombok:1.18.34")

    // Gson
    implementation ("com.google.code.gson:gson:2.10.1")

    // AndroidX and Material
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.12.0")
    implementation ("androidx.activity:activity:1.9.2")           // Thay thế libs.activity
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4") // Thay thế libs.constraintlayout

    // Retrofit and OkHttp
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")

    // MPAndroidChart
    implementation ("com.github.PhilJay:MPAndroidChart:v3.1.0")   // Cập nhật lên v3.1.0 như yêu cầu

    // Google Sign-In and Credentials (giả định từ libs)
    implementation ("com.google.android.gms:play-services-auth:20.7.0") // Thay thế libs.credentials.play.services.auth
    implementation ("com.google.api-client:google-api-client-android:2.2.0") // Thay thế libs.googleid
    implementation ("androidx.credentials:credentials:1.2.2")    // Thay thế libs.credentials

    // Local libraries (AAR, JAR)
        implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.aar", "*.jar"))))

    // Test dependencies
    testImplementation ("junit:junit:4.13.2")                     // Thay thế libs.junit
    androidTestImplementation ("androidx.test.ext:junit:1.2.1")  // Thay thế libs.ext.junit
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.6.1") // Thay thế libs.espresso.core
}