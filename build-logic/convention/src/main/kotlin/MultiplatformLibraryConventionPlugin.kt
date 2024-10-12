
import moe.chika.app.convention.config.RootConfig.JVM_TARGET
import moe.chika.app.convention.configureKotlinJvm
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

class MultiplatformLibraryConventionPlugin : Plugin<Project> {
  @OptIn(ExperimentalWasmDsl::class, ExperimentalKotlinGradlePluginApi::class)
  override fun apply(target: Project) = with(target) {
    pluginManager.apply("org.jetbrains.kotlin.multiplatform")

    extensions.configure<KotlinMultiplatformExtension> {
      wasmJs {
        browser {
          val projectDirPath = project.projectDir.path
          commonWebpackConfig {
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

      androidTarget {
        compilerOptions {
          jvmTarget.set(JVM_TARGET)
        }
      }

      iosX64()
      iosArm64()
      iosSimulatorArm64()

      jvm()

      configureKotlinJvm()
    }
  }
}
