import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
  `kotlin-dsl`
}

group = "moe.chika.app.buildlogic"

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
  compilerOptions {
    jvmTarget = JvmTarget.JVM_17
  }
}

dependencies {
  compileOnly(androidx.gradlePlugin)
  compileOnly(androidx.tools.common)
  compileOnly(libs.compose.gradlePlugin)
  compileOnly(libs.kotlin.compose.gradlePlugin)
  compileOnly(libs.kotlin.gradlePlugin)
}

tasks {
  validatePlugins {
    enableStricterValidation = true
    failOnWarning = true
  }
}

gradlePlugin {
  plugins {
    register("androidApplication") {
      id = "chika.android.application"
      implementationClass = "AndroidApplicationConventionPlugin"
    }
    register("androidLibrary") {
      id = "chika.android.library"
      implementationClass = "AndroidLibraryConventionPlugin"
    }
    register("androidLibraryCompose") {
      id = "chika.android.library.compose"
      implementationClass = "AndroidLibraryComposeConventionPlugin"
    }
    register("multiplatformApplication") {
      id = "chika.multiplatform.application"
      implementationClass = "MultiplatformApplicationConventionPlugin"
    }
    register("multiplatformLibraryCompose") {
      id = "chika.multiplatform.library.compose"
      implementationClass = "MultiplatformLibraryComposeConventionPlugin"
    }
    register("multiplatformLibrary") {
      id = "chika.multiplatform.library"
      implementationClass = "MultiplatformLibraryConventionPlugin"
    }
    register("versioning") {
      id = "chika.versioning"
      implementationClass = "VersioningConventionPlugin"
    }
    register("jvmLibrary") {
      id = "chika.jvm"
      implementationClass = "JvmLibraryConventionPlugin"
    }
  }
}
