plugins {
  id(libs.plugins.chika.android.library.asProvider().get().pluginId)
  id(libs.plugins.chika.multiplatform.library.asProvider().get().pluginId)
}

android {
  namespace = "moe.chika.app.core.common"
}

kotlin {
  sourceSets.commonMain.dependencies {
    implementation(libs.kotlinx.datetime)
  }
}
