import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
  id(libs.plugins.chika.multiplatform.application.get().pluginId)
}

kotlin {
  @OptIn(ExperimentalWasmDsl::class)
  wasmJs {
    moduleName = "Chika"
    browser {
      version
      val projectDirPath = project.projectDir.path
      commonWebpackConfig {
        outputFileName = "chika.js"
        devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
          static = (static ?: mutableListOf()).apply {
            // Serve sources to debug inside browser
            add(projectDirPath)
          }
        }
      }
    }
    binaries.executable()
  }
}
