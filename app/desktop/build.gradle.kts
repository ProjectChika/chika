import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
  id(libs.plugins.chika.multiplatform.application.get().pluginId)
}

kotlin {
  jvm("desktop")

  sourceSets {
    val desktopMain by getting

    desktopMain.dependencies {
      implementation(compose.desktop.currentOs)
      implementation(libs.kotlinx.coroutines.swing)
    }
  }
}

compose.desktop {
  application {
    mainClass = "moe.chika.app.MainKt"

    nativeDistributions {
      targetFormats(
        TargetFormat.Dmg,
        TargetFormat.Msi,
        TargetFormat.Deb,
        TargetFormat.Exe,
        TargetFormat.Pkg,
        TargetFormat.AppImage
      )
      packageName = "moe.chika.app"
    }
  }
}
