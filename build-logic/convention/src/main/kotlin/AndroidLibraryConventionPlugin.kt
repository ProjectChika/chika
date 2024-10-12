
import com.android.build.api.dsl.LibraryExtension
import moe.chika.app.convention.config.AndroidConfig.TARGET_SDK
import moe.chika.app.convention.configureFlavors
import moe.chika.app.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) = with(target) {
    with(pluginManager) {
      apply("com.android.library")
      apply("org.jetbrains.kotlin.multiplatform")
    }

    extensions.configure<LibraryExtension> {
      configureFlavors(this)
      configureKotlinAndroid(this)
      testOptions {
        animationsDisabled = true
        targetSdk = TARGET_SDK

        unitTests.all {
          it.useJUnitPlatform()
        }
      }
    }
  }
}
