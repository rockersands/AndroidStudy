plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.dagger.hilt.android)
    kotlin("kapt")

}
hilt {
    enableAggregatingTask = false
}
android {
    namespace = "com.example.cleanarch3"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.cleanarch3"
        minSdk = 27
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
            sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

hilt {
    enableAggregatingTask = true
}

kapt {
    correctErrorTypes = true
}

dependencies {
    kapt(libs.androidx.room.compiler)

    // Core UI libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Retrofit & OkHttp
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)

    // Dagger Hilt and Navigation
    implementation(libs.dagger.hilt.android)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.room.common)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.fragment.ktx)
    kapt(libs.dagger.hilt.compiler)

    // AndroidX Lifecycle (for MVVM)
    implementation(libs.lifecycle.runtime)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.livedata)

    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "17"
}
tasks.withType<org.jetbrains.kotlin.gradle.internal.KaptGenerateStubsTask>().configureEach {
    kotlinOptions.jvmTarget = "17"
}
