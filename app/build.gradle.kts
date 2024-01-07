plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.aplikasijogging"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.aplikasijogging"
        minSdk = 34
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation ("androidx.core:core-ktx:1.10.1")
    implementation (platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation ("androidx.activity:activity-compose:1.7.2")
    implementation (platform("androidx.compose:compose-bom:2023.06.01"))
    implementation ("androidx.compose.ui:ui")
    implementation ("androidx.compose.ui:ui-graphics")
    implementation ("androidx.compose.ui:ui-tooling-preview")
    implementation ("androidx.compose.material3:material3")
    implementation ("androidx.compose.material:material")
    implementation("com.google.firebase:firebase-firestore-ktx:24.10.0")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation (platform("androidx.compose:compose-bom:2023.06.01"))
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4")
    debugImplementation ("androidx.compose.ui:ui-tooling")
    debugImplementation ("androidx.compose.ui:ui-test-manifest")

    //navigasi
    implementation ("androidx.navigation:navigation-compose: ${rootProject.findProperty("nav_version")}")

    //google maps
    implementation ("com.google.maps.android:maps-compose:2.11.4")
    implementation ("com.google.android.gms:play-services-maps:18.1.0")
    implementation ("com.google.android.gms:play-services-location:21.0.1")

    //dagger hilt
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation ("com.google.dagger:hilt-android:${rootProject.findProperty("hilt_version")}")
    kapt ("com.google.dagger:hilt-compiler:${rootProject.findProperty("hilt_version")}")

    // lifecycle
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:${rootProject.findProperty("lifecycle_version")}")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:${rootProject.findProperty("lifecycle_version")}")
    implementation ("androidx.lifecycle:lifecycle-runtime-compose:${rootProject.findProperty("lifecycle_version")}")
    implementation ("androidx.lifecycle:lifecycle-service:${rootProject.findProperty("lifecycle_version")}")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:${rootProject.findProperty("lifecycle_version")}")

    //Timber
    implementation ("com.jakewharton.timber:timber:5.0.1")

    //room database
    implementation ("androidx.room:room-runtime:${rootProject.findProperty("room_version")}")
    annotationProcessor ("androidx.room:room-compiler:${rootProject.findProperty("room_version")}")
    kapt ("androidx.room:room-compiler:${rootProject.findProperty("room_version")}")
    implementation ("androidx.room:room-ktx:${rootProject.findProperty("room_version")}")
    implementation ("androidx.room:room-paging:${rootProject.findProperty("room_version")}")

    //datastore
    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    //coil
    implementation("io.coil-kt:coil-compose:2.4.0")

    implementation ("androidx.paging:paging-runtime:${rootProject.findProperty("paging_version")}")
    implementation ("androidx.paging:paging-compose:3.2.0")
}

kapt {
    correctErrorTypes = true
}