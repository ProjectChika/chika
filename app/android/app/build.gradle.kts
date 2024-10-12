import moe.chika.app.convention.BuildTypes

plugins {
  id(libs.plugins.chika.android.application.get().pluginId)
}

android {
  namespace = "moe.chika.app"

  defaultConfig {
    applicationId = "moe.chika.app"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  signingConfigs {
    getByName("debug") {
      storeFile = rootProject.file("release/app-debug.jks")
      storePassword = "android"
      keyAlias = "androiddebugkey"
      keyPassword = "android"
    }

    if (rootProject.file("release/app-release.jks").exists()) {
      create("release") {
        storeFile = rootProject.file("release/app-release.jks")
        storePassword = properties["CHIKA_RELEASE_KEYSTORE_PWD"]?.toString().orEmpty()
        keyAlias = "tivi"
        keyPassword = properties["CHIKA_RELEASE_KEY_PWD"]?.toString().orEmpty()
      }
    }
  }

  buildTypes {
    debug {
      applicationIdSuffix = BuildTypes.DEBUG.applicationIdSuffix
    }
    release {
      isMinifyEnabled = true
      applicationIdSuffix = BuildTypes.RELEASE.applicationIdSuffix
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
    }
  }

  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {
  implementation(androidx.activity.compose)

  implementation(compose.preview)
  debugImplementation(compose.uiTooling)
}
