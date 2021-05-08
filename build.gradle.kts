// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        maven(
            uri("${rootDir}/.repos")
        )
        mavenCentral()
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

/**
 * 如果在多项目构建中，可能想把插件应用到子项目中，apply false 来告诉 Gradle 不要应用插件
 *
 * plugins {} 默认的行为是解析和应用插件
 */
plugins {
    id("com.vdreamers.version.plugin")
}

allprojects {
    repositories {
        maven(
            uri("${rootDir}/.repos")
        )
        mavenCentral()
        google()
        jcenter()
    }
}

subprojects {
    afterEvaluate {
        // 所有子项目依赖插件
        apply(plugin = "com.vdreamers.version.plugin")
    }
}

tasks.register<Delete>(name = "clean") {
    group = "build"
    delete(rootProject.buildDir)
}