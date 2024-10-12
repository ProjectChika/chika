import moe.chika.app.convention.configureCompose
import org.gradle.api.Plugin
import org.gradle.api.Project

class MultiplatformLibraryComposeConventionPlugin : Plugin<Project> {
  override fun apply(target: Project): Unit = with(target) {
    with(pluginManager) {
      apply("org.jetbrains.compose")
      apply("org.jetbrains.kotlin.plugin.compose")
    }

    configureCompose()
  }
}
