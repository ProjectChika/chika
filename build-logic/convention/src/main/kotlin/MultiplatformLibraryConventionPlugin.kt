
import moe.chika.app.convention.config.RootConfig.JVM_TARGET
import moe.chika.app.convention.configureKotlinMultiplatform
import moe.chika.app.convention.extension.libs
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
    with(pluginManager) {
      apply("org.jetbrains.kotlin.multiplatform")
    }

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

      // Disable iOS for now
//      iosX64()
//      iosArm64()
//      iosSimulatorArm64()

      jvm()

      configureKotlinMultiplatform()

      sourceSets.commonMain.dependencies {
        val bom = libs.findLibrary("arrow.stack").get()
        implementation(project.dependencies.platform(bom))
        implementation(libs.findLibrary("arrow.core").get())
        implementation(libs.findLibrary("arrow.fx.coroutines").get())
      }
    }
  }
}
