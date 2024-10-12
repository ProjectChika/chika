plugins {
  id(libs.plugins.chika.multiplatform.application.get().pluginId)
}

kotlin {
  listOf(
    iosX64(),
    iosArm64(),
    iosSimulatorArm64()
  ).forEach { iosTarget ->
    iosTarget.binaries.framework {
      baseName = "Chika"
      isStatic = true
    }
  }
}
