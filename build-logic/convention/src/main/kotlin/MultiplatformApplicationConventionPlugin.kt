import org.gradle.api.Plugin
import org.gradle.api.Project

class MultiplatformApplicationConventionPlugin: Plugin<Project> {
  override fun apply(target: Project) = with(target) {
    with(pluginManager) {
      apply("org.jetbrains.kotlin.multiplatform")
      apply("org.jetbrains.compose")
      apply("org.jetbrains.kotlin.plugin.compose")
    }
  }
}
