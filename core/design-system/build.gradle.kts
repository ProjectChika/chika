plugins {
  id(libs.plugins.chika.android.library.asProvider().get().pluginId)
  id(libs.plugins.chika.multiplatform.library.asProvider().get().pluginId)
  id(libs.plugins.chika.multiplatform.library.compose.get().pluginId)
}

kotlin {
  sourceSets {
    commonMain {
      dependencies {
        api(compose.runtime)
        api(compose.foundation)
        api(compose.material)
        api(compose.ui)
        api(compose.components.resources)
        api(compose.components.uiToolingPreview)
      }
    }
  }
}

android {
  namespace = "moe.chika.app.designsystem"
}
