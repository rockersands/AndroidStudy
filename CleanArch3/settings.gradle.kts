pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "dagger.hilt.android.plugin") {
                // Tell Gradle to fetch the Hilt plugin from the specified module
                useModule("com.google.dagger:hilt-android-gradle-plugin:2.47")
            }
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CleanArch3"
include(":app")
 