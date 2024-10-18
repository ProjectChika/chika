import moe.chika.app.convention.extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KoinMultiplatformConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) = with(target) {
    extensions.configure<KotlinMultiplatformExtension> {
      val bom = libs.findLibrary("koin.bom").get()
      sourceSets.commonMain.dependencies {
        implementation(project.dependencies.platform(bom))
        implementation(libs.findLibrary("koin.core"))
      }
      sourceSets.commonTest.dependencies {
        implementation(project.dependencies.platform(bom))
        implementation(libs.findLibrary("koin.test"))
      }
    }
  }
}
