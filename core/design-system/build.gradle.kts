plugins {
  id(libs.plugins.chika.android.library.asProvider().get().pluginId)
  id(libs.plugins.chika.multiplatform.library.asProvider().get().pluginId)
  id(libs.plugins.chika.multiplatform.library.compose.get().pluginId)
}

kotlin {
  sourceSets {
    androidMain.dependencies {
      implementation(androidx.core.ktx)
    }
    commonMain.dependencies {
      api(compose.runtime)
      api(compose.foundation)
      api(compose.material3)
      api(compose.ui)
      api(compose.components.resources)
      api(compose.components.uiToolingPreview)

    }
  }
}

compose.resources {
  publicResClass = false
  packageOfResClass = "moe.chika.app.core.designsystem.resources"
  generateResClass = auto
}

android {
  namespace = "moe.chika.app.designsystem"
}
