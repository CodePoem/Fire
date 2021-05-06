import com.vdreamers.fire.AppBuildInfos
import com.vdreamers.version.Deps

plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdkVersion(AppBuildInfos.COMPILE_SDK_VERSION)
    buildToolsVersion(AppBuildInfos.BUILD_TOOLS_VERSION)

    defaultConfig {
        applicationId(AppBuildInfos.APPLICATION_ID)
        minSdkVersion(AppBuildInfos.MIN_SDK_VERSION)
        targetSdkVersion(AppBuildInfos.TARGET_SDK_VERSION)
        versionCode(AppBuildInfos.VERSION_CODE)
        versionName(AppBuildInfos.VERSION_NAME)

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
    }

    buildTypes {
        val release = getByName("release")
        release.apply {
            minifyEnabled(false)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
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
    implementation(Deps.Kotlin.STDLIB)
    implementation(Deps.AndroidX.CORE_KTX)
    implementation(Deps.AndroidX.APPCOMPAT)
    implementation(Deps.AndroidX.CONSTRAINT_LAYOUT)
    implementation(Deps.Google.MATERIAL)
    testImplementation(Deps.Test.JUNIT)
    androidTestImplementation(Deps.AndroidTest.JUNIT)
    androidTestImplementation(Deps.AndroidTest.ESPRESSO_CORE)
}