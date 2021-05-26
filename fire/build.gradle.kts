import com.vdreamers.fire.AppBuildConfigs
import com.vdreamers.version.Deps

plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdkVersion(AppBuildConfigs.COMPILE_SDK_VERSION)
    buildToolsVersion(AppBuildConfigs.BUILD_TOOLS_VERSION)

    defaultConfig {
        minSdkVersion(AppBuildConfigs.MIN_SDK_VERSION)
        targetSdkVersion(AppBuildConfigs.TARGET_SDK_VERSION)
        versionCode(AppBuildConfigs.VERSION_CODE)
        versionName(AppBuildConfigs.VERSION_NAME)

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        val debug = getByName("debug")
        debug.apply {
            minifyEnabled(false)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        val release = getByName("release")
        release.apply {
            minifyEnabled(false)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    compileOnly(Deps.Kotlin.stdlib())
    api(project(":fire-core"))

    testImplementation(Deps.Test.junit())
    androidTestImplementation(Deps.AndroidTest.junit())
    androidTestImplementation(Deps.AndroidTest.espressoCore())
}

apply(from = "${rootProject.projectDir}/publish.gradle")