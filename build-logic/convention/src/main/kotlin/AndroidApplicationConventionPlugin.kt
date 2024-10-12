
import com.android.build.api.dsl.ApplicationExtension
import moe.chika.app.convention.config.AndroidConfig.TARGET_SDK
import moe.chika.app.convention.config.RootConfig.JVM_TARGET
import moe.chika.app.convention.configureAndroidCompose
import moe.chika.app.convention.configureFlavors
import moe.chika.app.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class AndroidApplicationConventionPlugin : Plugin<Project> {
  @OptIn(ExperimentalKotlinGradlePluginApi::class)
  override fun apply(target: Project) = with(target) {
    with(pluginManager) {
      apply("com.android.application")
      apply("org.jetbrains.kotlin.multiplatform")
      apply("org.jetbrains.compose")
      apply("org.jetbrains.kotlin.plugin.compose")
    }

    extensions.configure<ApplicationExtension> {
      configureAndroidCompose(this)
      configureKotlinAndroid(this)
      configureFlavors(this)
      defaultConfig.targetSdk = TARGET_SDK
    }

    extensions.configure<KotlinMultiplatformExtension> {
      androidTarget {
        compilerOptions {
          jvmTarget.set(JVM_TARGET)
        }
      }
    }
  }
}
