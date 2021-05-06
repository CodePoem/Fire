import com.vdreamers.fire.AppBuildInfos
import com.vdreamers.version.Deps

plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdkVersion(AppBuildInfos.COMPILE_SDK_VERSION)
    buildToolsVersion(AppBuildInfos.BUILD_TOOLS_VERSION)

    defaultConfig {
        minSdkVersion(AppBuildInfos.MIN_SDK_VERSION)
        targetSdkVersion(AppBuildInfos.TARGET_SDK_VERSION)
        versionCode(AppBuildInfos.VERSION_CODE)
        versionName(AppBuildInfos.VERSION_NAME)

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
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

    testImplementation(Deps.Test.junit())
    androidTestImplementation(Deps.AndroidTest.junit())
    androidTestImplementation(Deps.AndroidTest.espressoCore())
}