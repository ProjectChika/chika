import com.android.build.api.dsl.LibraryExtension
import moe.chika.app.convention.configureAndroidCompose
import moe.chika.app.convention.configureCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) = with(target) {
    with(pluginManager) {
      apply("com.android.library")
      apply("org.jetbrains.kotlin.plugin.compose")
    }

    extensions.configure<LibraryExtension> {
      configureAndroidCompose(this)
      configureCompose()
    }
  }
}
